CREATE TABLE country (
  id        IDENTITY,
  name      VARCHAR(255),
  code_name VARCHAR(255)
);

CREATE TABLE person (
  id IDENTITY,
  name VARCHAR(100),
  country_id INT,


  FOREIGN KEY (country_id) REFERENCES country (id)
)