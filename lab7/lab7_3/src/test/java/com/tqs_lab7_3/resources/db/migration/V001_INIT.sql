CREATE TABLE books (
  id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  name VARCHAR(100) NOT NULL
);

INSERT INTO books ("name") 
VALUES 
('Harry Potter'),
('Uma Aventura'),
('Cuidado com o Cão'), 
('O Homem Que Morreu Duas Vezes');