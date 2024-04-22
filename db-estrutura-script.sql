-- Role: dbamaster
-- DROP ROLE IF EXISTS dbamaster;

CREATE ROLE dbamaster WITH
  LOGIN
  SUPERUSER
  INHERIT
  CREATEDB
  CREATEROLE
  REPLICATION
  ENCRYPTED PASSWORD 'md5678a4b8a902fcfc6bc16240e9da171a1';  /*admin*/

-- Database: db_cadastro_pessoas

-- DROP DATABASE IF EXISTS db_cadastro_pessoas;
CREATE DATABASE db_cadastro_pessoas
    WITH
    OWNER = dbamaster
    ENCODING = 'UTF8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;
	

-- SCHEMA: sch_desafio

-- DROP SCHEMA IF EXISTS sch_desafio ;

CREATE SCHEMA IF NOT EXISTS sch_desafio AUTHORIZATION dbamaster;

-- Table: sch_desafio.pessoa

-- DROP TABLE IF EXISTS sch_desafio.pessoa;

CREATE TABLE IF NOT EXISTS sch_desafio.pessoa
(
    id bigserial NOT NULL,
    nome character varying(150) COLLATE pg_catalog."default",
    cpf character varying(255) COLLATE pg_catalog."default",
    sexo character varying(1) COLLATE pg_catalog."default",
    idade character varying(255) COLLATE pg_catalog."default",
    data_nascimento date,
    data_cadastro timestamp without time zone,
    CONSTRAINT pessoa_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE IF EXISTS sch_desafio.pessoa OWNER to dbamaster;

	
-- Table: sch_desafio.estado

-- DROP TABLE IF EXISTS sch_desafio.estado;

CREATE TABLE IF NOT EXISTS sch_desafio.estado
(
    id bigserial NOT NULL,
    nome character varying(255) COLLATE pg_catalog."default",
    uf character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT estado_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE IF EXISTS sch_desafio.estado OWNER to dbamaster;  



-- Table: sch_desafio.cidade

-- DROP TABLE IF EXISTS sch_desafio.cidade;

CREATE TABLE IF NOT EXISTS sch_desafio.cidade
(
    id bigserial NOT NULL,
    nome character varying(255) COLLATE pg_catalog."default",
    estado_id bigint,
    CONSTRAINT cidade_pkey PRIMARY KEY (id),
    CONSTRAINT fk_cidade_estado_id FOREIGN KEY (estado_id) REFERENCES sch_desafio.estado (id) 
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE IF EXISTS sch_desafio.cidade OWNER to dbamaster;
    

-- Table: sch_desafio.endereco

-- DROP TABLE IF EXISTS sch_desafio.endereco;

CREATE TABLE IF NOT EXISTS sch_desafio.endereco
(
    id bigserial NOT NULL,
    bairro character varying(60) COLLATE pg_catalog."default",
    cep character varying(10) COLLATE pg_catalog."default",
    complemento character varying(120) COLLATE pg_catalog."default",
    logradouro character varying(120) COLLATE pg_catalog."default",
    numero character varying(20) COLLATE pg_catalog."default",
    uf character varying(2) COLLATE pg_catalog."default",
    cidade_id bigint,
    pessoa_id bigint NOT NULL,
    CONSTRAINT endereco_pkey PRIMARY KEY (id),
    CONSTRAINT fk_endereco_cidade_id FOREIGN KEY (cidade_id) REFERENCES sch_desafio.cidade (id),
    CONSTRAINT fk_endereco_pessoa_id FOREIGN KEY (pessoa_id) REFERENCES sch_desafio.pessoa (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE IF EXISTS sch_desafio.endereco OWNER to dbamaster;