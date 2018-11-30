CREATE TABLE profile_user
(
    user_id bigint NOT NULL,
    contact_name character varying(245) COLLATE pg_catalog."default" NOT NULL,
    contact_name_lc character varying(245) COLLATE pg_catalog."default" NOT NULL,
    create_date timestamp without time zone DEFAULT now(),
    update_date timestamp without time zone DEFAULT now(),
    login_name character varying(65) COLLATE pg_catalog."default" NOT NULL,
    login_name_lc character varying(120) COLLATE pg_catalog."default" NOT NULL,
    first_name character varying(120) COLLATE pg_catalog."default",
    first_name_nls character varying(240) COLLATE pg_catalog."default",
    last_name character varying(120) COLLATE pg_catalog."default",
    last_name_nls character varying(240) COLLATE pg_catalog."default",
    display_name character varying(245) COLLATE pg_catalog."default",
    email character varying(320) COLLATE pg_catalog."default",
    email_lc character varying(320) COLLATE pg_catalog."default",
    country character varying(128) COLLATE pg_catalog."default",
    email_verify boolean  DEFAULT 'F'::boolean,
    deleted_date timestamp without time zone,
    account_type character varying(20) COLLATE pg_catalog."default",
    enabled character varying(1) COLLATE pg_catalog."default" NOT NULL,
    phone_number character varying(20) COLLATE pg_catalog."default",
    CONSTRAINT pk_profile_user PRIMARY KEY (user_id),
    CONSTRAINT uk_profile_user_login_name_lc UNIQUE (login_name_lc),
    CONSTRAINT uk_profile_user_contact_name_lc UNIQUE (contact_name_lc),
    CONSTRAINT chk_profile_user_email_verify CHECK (email_verify::boolean = ANY (ARRAY['T'::boolean::boolean, 'F'::boolean::boolean])),
    CONSTRAINT chk_profile_user_enabled CHECK (enabled::text = ANY (ARRAY['T'::character varying::text, 'F'::character varying::text, 'D﻿'::character varying::text]))
)

CREATE SEQUENCE SEQ_PROFILE_USER START WITH 1000;

CREATE TABLE profile_patient
(
    user_id bigint NOT NULL,
    first_name character varying(120) COLLATE pg_catalog."default",
    first_name_nls character varying(240) COLLATE pg_catalog."default",
    last_name character varying(120) COLLATE pg_catalog."default",
    last_name_nls character varying(240) COLLATE pg_catalog."default",
    medical character varying(245) COLLATE pg_catalog."default",
    email character varying(320) COLLATE pg_catalog."default",
    email_lc character varying(320) COLLATE pg_catalog."default",
    country character varying(128) COLLATE pg_catalog."default",
    email_vrfy boolean  DEFAULT 'F'::boolean,
    deleted_date timestamp without time zone,
    image_url character varying(2000) COLLATE pg_catalog."default",
    account_type character varying(20) COLLATE pg_catalog."default",
    enabled character varying(1) COLLATE pg_catalog."default" NOT NULL,
    --deleted_date timestamp without time zone,
    CONSTRAINT pk_profile_user PRIMARY KEY (user_id),
    CONSTRAINT uk_profile_user_login_name_lc UNIQUE (login_name_lc),
    CONSTRAINT uk_profile_user_contact_name_lc UNIQUE (contact_name_lc),
    CONSTRAINT chk_profile_user_email_vrfy CHECK (email_vrfy::boolean = ANY (ARRAY['T'::boolean::boolean, 'F'::boolean::boolean])),
    CONSTRAINT chk_profile_user_enabled CHECK (enabled::text = ANY (ARRAY['T'::character varying::text, 'F'::character varying::text, 'D﻿'::character varying::text]))
)