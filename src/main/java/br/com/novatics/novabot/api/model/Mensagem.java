package br.com.novatics.novabot.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.novatics.novabot.api.model.util.Modelo;

@Entity
public class Mensagem extends Modelo {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@JsonProperty(value = "token")
	private String token;

	@JsonProperty(value = "team_id")
	private String teamId;

	@JsonProperty(value = "team_domain")
	private String teamDomain;

	@JsonProperty(value = "enterprise_id")
	private String enterpriseId;

	@JsonProperty(value = "enterprise_name")
	private String enterpriseName;
	
	@JsonProperty(value = "channel_id")
	private String channelId;

	@JsonProperty(value = "channel_name")
	private String channelName;

	@JsonProperty(value = "user_id")
	private String userId;

	@JsonProperty(value = "user_name")
	private String userName;

	@JsonProperty(value = "command")
	private String command;

	@JsonProperty(value = "text")
	private String text;

	@JsonProperty(value = "response_url")
	private String responseUrl;

	@JsonProperty(value = "trigger_id")
	private String triggerId;

	public Long getId() {
		return id;
	}

	public String getToken() {
		return token;
	}

	public String getTeamId() {
		return teamId;
	}

	public String getTeamDomain() {
		return teamDomain;
	}

	public String getEnterpriseId() {
		return enterpriseId;
	}

	public String getChannelId() {
		return channelId;
	}

	public String getChannelName() {
		return channelName;
	}

	public String getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public String getCommand() {
		return command;
	}

	public String getText() {
		return text;
	}

	public String getResponseUrl() {
		return responseUrl;
	}

	public String getTriggerId() {
		return triggerId;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public void setTeamDomain(String teamDomain) {
		this.teamDomain = teamDomain;
	}

	public void setEnterpriseId(String enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setResponseUrl(String responseUrl) {
		this.responseUrl = responseUrl;
	}

	public void setTriggerId(String triggerId) {
		this.triggerId = triggerId;
	}
	
}
