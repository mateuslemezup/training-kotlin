CREATE TABLE exchange_log (
  id binary(16) NOT NULL,
  typing_date DATETIME  NOT NULL,
  real_amount decimal(15,2) NOT NULL,
  dolar_amount decimal(15,2) NOT NULL,
  PRIMARY KEY (id)
);