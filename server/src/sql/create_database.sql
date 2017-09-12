-- Database: fdfdevdb

-- DROP DATABASE fdfdevdb;

CREATE DATABASE fdfdevdb
WITH
OWNER = postgres
ENCODING = 'UTF8'
LC_COLLATE = 'English_United Kingdom.1252'
LC_CTYPE = 'English_United Kingdom.1252'
TABLESPACE = pg_default
CONNECTION LIMIT = -1;

GRANT TEMPORARY, CONNECT ON DATABASE fdfdevdb TO PUBLIC;

GRANT ALL ON DATABASE fdfdevdb TO postgres;

GRANT ALL ON DATABASE fdfdevdb TO fdfdev;