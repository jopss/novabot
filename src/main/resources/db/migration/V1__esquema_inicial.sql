CREATE SEQUENCE HIBERNATE_SEQUENCE START WITH 100;    

CREATE TABLE MENSAGEM(
    ID BIGINT NOT NULL,
    DATA_CRIACAO TIMESTAMP,
    token VARCHAR(100),
    team_id VARCHAR(100),
    team_domain VARCHAR(100),
    enterprise_id VARCHAR(100),
    enterprise_name VARCHAR(100),
    channel_id VARCHAR(100),
    channel_name VARCHAR(100),
    user_id VARCHAR(100),
    user_name VARCHAR(100),
    command VARCHAR(100),
    text VARCHAR(100),
    response_url VARCHAR(100),
    trigger_id VARCHAR(100)
);           
ALTER TABLE MENSAGEM ADD CONSTRAINT PK_MENSAGEM PRIMARY KEY(ID);
