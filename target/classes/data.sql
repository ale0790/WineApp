DROP TABLE IF EXISTS LOJA_FAIXA_CEP;

CREATE TABLE LOJA_FAIXA_CEP (
  ID INT AUTO_INCREMENT  PRIMARY KEY,
  CODIGO_LOJA VARCHAR(250) NOT NULL,
  FAIXA_INICIO VARCHAR(250) NOT NULL,
  FAIXA_FIM VARCHAR(250) NOT NULL
);

INSERT INTO LOJA_FAIXA_CEP (CODIGO_LOJA, FAIXA_INICIO, FAIXA_FIM) VALUES
  ('LOJA_PINHEIROS', 05400 , 05499),
  ('LOJA_JARDINS', 01300 , 01399),
  ('LOJA_MOEMA', 04000, 04099);