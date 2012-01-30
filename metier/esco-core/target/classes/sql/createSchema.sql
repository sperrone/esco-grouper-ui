CREATE SCHEMA DBPARAMETER;
SET SCHEMA DBPARAMETER;

DROP TABLE DBPARAMETER.param;
CREATE TABLE DBPARAMETER.param (
	param_id INT NOT NULL GENERATED ALWAYS AS IDENTITY,
	pkey VARCHAR(255) NOT NULL,
	pgroup VARCHAR(512) NOT NULL,
	param_key VARCHAR(255) NOT NULL,
	param_value VARCHAR(512) NOT NULL,
	param_comment VARCHAR(512),
	initial_value VARCHAR(512),
	form_file VARCHAR(512),
	PRIMARY KEY (param_id));

