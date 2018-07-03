package br.com.novatics.novabot.api.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Modifier;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Properties;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.MessageFormat;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.io.IOUtils;

/**
 * Formatacao e conversao de valores diversos.
 */
public final class FormatadorUtil {
	
	public static <T> T convertJsonToObject(String json, Class clazz) {
		Gson gson = new GsonBuilder().setPrettyPrinting().setDateFormat("dd/MM/yyyy HH:mm:ss").excludeFieldsWithModifiers(Modifier.TRANSIENT, Modifier.STATIC).setExclusionStrategies(
				new ExcludeJSonStrategy()).create();

		return (T) gson.fromJson(json, clazz);
	}
	
	/**
	 * Transforma um objeto em sua representacao JSon.<br/><br/>
	 * Remove do JSON os campos transientes, estaticos e que contenha a anotacao @ExcludeJSon. Ainda, formata o valor das datas para padrao pt-BR (dd/MM/yyyy HH:mm:ss).
	 */
	public static String convertToJson(Object obj) {

		Gson gson = new GsonBuilder().setPrettyPrinting().setDateFormat("dd/MM/yyyy HH:mm:ss")
			.excludeFieldsWithModifiers(Modifier.TRANSIENT, Modifier.STATIC)
			.setExclusionStrategies(new ExcludeJSonStrategy()).create();

		return gson.toJson(obj);
	}
	
	public static byte[] convertHexaToBase64(char[] hex) throws DecoderException {
		byte[] decodedHex = Hex.decodeHex(hex);
		byte[] encodedHexB64 = Base64.encodeBase64(decodedHex);
		return encodedHexB64;
	}

	public static byte[] decodeBase64(byte[] base64) throws DecoderException {
		return Base64.decodeBase64(base64);
	}
	
	/**
	 * Retorna o valor de uma chave do arquivo "messages.properties".
	 */
	public static String getMessage(String key, String... args) {

		try {
			InputStream istream = FormatadorUtil.class.getClassLoader().getResourceAsStream("messages.properties");
			if (istream != null) {
				Properties props = new Properties();
				props.load(istream);
                                
                                String value = props.getProperty(key.trim());
                                
                                if(args!=null && args.length > 0){
                                        return MessageFormat.format(value, args);
                                }
                                
				return value;
			}
			return key;

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static String getMessage(String file, String key) {

		try {
			InputStream istream = FormatadorUtil.class.getClassLoader().getResourceAsStream(file);
			if (istream != null) {
				Properties props = new Properties();
				props.load(istream);
				return props.getProperty(key.trim());
			}
			return key;

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static String parseCpfCnpj(String cpfCnpj) {
		if (ValidadorUtils.isNotNullAndNotEmpty(cpfCnpj)) {
			cpfCnpj = cpfCnpj.trim();
			cpfCnpj = StringsUtils.replaceSpecial(cpfCnpj);

			if (cpfCnpj.equals("0") || cpfCnpj.equals("00000000000") || cpfCnpj.equals("00000000000000")) {
				return null; //para retornar a pessoa 'NAO EXISTE'.
			}
			
			cpfCnpj = cpfCnpj.replaceAll(" ", "");
			return parseCpfCnpj(Long.parseLong(cpfCnpj));
		}

		return null;
	}

	public static String parseCpfCnpj(Long cpfCnpj) {
		String sCpfCnpj = "" + cpfCnpj;

		if (sCpfCnpj.length() <= 11) {
			NumberFormat nf = new DecimalFormat("00000000000");
			sCpfCnpj = nf.format(cpfCnpj);
		} else if (sCpfCnpj.length() <= 14) {
			NumberFormat nf = new DecimalFormat("00000000000000");
			sCpfCnpj = nf.format(cpfCnpj);
		}

		if (sCpfCnpj.length() == 11) {

			String grupo1 = sCpfCnpj.substring(0, 3);
			String grupo2 = sCpfCnpj.substring(3, 6);
			String grupo3 = sCpfCnpj.substring(6, 9);
			String digitos = sCpfCnpj.substring(9, 11);

			return grupo1 + "." + grupo2 + "." + grupo3 + "-" + digitos;
		} else if (sCpfCnpj.length() == 14) {

			String grupo1 = sCpfCnpj.substring(0, 2);
			String grupo2 = sCpfCnpj.substring(2, 5);
			String grupo3 = sCpfCnpj.substring(5, 8);
			String grupo4 = sCpfCnpj.substring(8, 12);
			String digitos = sCpfCnpj.substring(12, 14);

			return grupo1 + "." + grupo2 + "." + grupo3 + "/" + grupo4 + "-" + digitos;
		}

		return sCpfCnpj;
	}

	/**
	 * Retorna um arquivo do resource do projeto.
	 * O nome deve começar com "/".
	 */
	public static String readResourceFile(String filename) throws IOException {
		InputStream in = FormatadorUtil.class.getResourceAsStream(filename);
		if (in == null) {
		    throw new FileNotFoundException("Arquivo '"+filename+"' inexistente em '/class/resources/'.");
		}
		return IOUtils.toString(in, Charset.forName("UTF-8"));
	}
	
	public static String encryptMD5(String text) {
		return encryptMD5(text.getBytes());
	}
	
	public static String encryptMD5(byte[] text) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(text);
			BigInteger hash = new BigInteger(1, md.digest());
			return org.apache.commons.lang3.StringUtils.leftPad(hash.toString(16), 32, '0');
		} catch (NoSuchAlgorithmException ex) {
			throw new RuntimeException(ex);
		}
	}
}
