-- noinspection SqlDialectInspectionForFile

-- noinspection SqlNoDataSourceInspectionForFile

--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.10
-- Dumped by pg_dump version 9.5.10

-- Started on 2017-11-20 13:31:49 -03

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 8 (class 2615 OID 79265926)
-- Name: ifpug; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA ifpug;


ALTER SCHEMA ifpug OWNER TO postgres;

--
-- TOC entry 9 (class 2615 OID 79265932)
-- Name: sisp; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA sisp;


ALTER SCHEMA sisp OWNER TO postgres;

--
-- TOC entry 1 (class 3079 OID 13318)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner:
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 3080 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner:
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = ifpug, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 183 (class 1259 OID 79265927)
-- Name: projeto_desenvolvimento; Type: TABLE; Schema: ifpug; Owner: postgres
--

CREATE TABLE projeto_desenvolvimento (
    id bigint NOT NULL,
    detalhes_id bigint,
    pfincluidos_id bigint
);


ALTER TABLE projeto_desenvolvimento OWNER TO postgres;

SET search_path = sisp, pg_catalog;

--
-- TOC entry 184 (class 1259 OID 79265933)
-- Name: projeto_melhoria; Type: TABLE; Schema: sisp; Owner: postgres
--

CREATE TABLE projeto_melhoria (
    id bigint NOT NULL,
    detalhes_id bigint,
    peso_funcao_excluida double precision NOT NULL,
    pfalterado_id bigint,
    pfconversao_id bigint,
    pfexcluido_id bigint,
    pfincluido_id bigint
);


ALTER TABLE projeto_melhoria OWNER TO postgres;

--
-- TOC entry 185 (class 1259 OID 79265938)
-- Name: projeto_migracao; Type: TABLE; Schema: sisp; Owner: postgres
--

CREATE TABLE projeto_migracao (
    id bigint NOT NULL,
    detalhes_id bigint,
    pfincluidos_id bigint
);

ALTER TABLE projeto_migracao OWNER TO postgres;


ALTER TABLE ONLY projeto_desenvolvimento
    ADD CONSTRAINT projeto_desenvolvimento_pkey PRIMARY KEY (id);


SET search_path = sisp, pg_catalog;

--
-- TOC entry 2953 (class 2606 OID 79265937)
-- Name: projeto_melhoria_pkey; Type: CONSTRAINT; Schema: sisp; Owner: postgres
--

ALTER TABLE ONLY projeto_melhoria
    ADD CONSTRAINT projeto_melhoria_pkey PRIMARY KEY (id);


--
-- TOC entry 2955 (class 2606 OID 79265942)
-- Name: projeto_migracao_pkey; Type: CONSTRAINT; Schema: sisp; Owner: postgres
--

ALTER TABLE ONLY projeto_migracao
    ADD CONSTRAINT projeto_migracao_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

