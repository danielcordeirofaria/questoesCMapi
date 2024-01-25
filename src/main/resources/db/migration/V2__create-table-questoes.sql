CREATE TABLE tbl_questoes (
    id_questao INT PRIMARY KEY AUTO_INCREMENT,
    ano_prova INT NOT NULL,
    numero_questao INT NOT NULL,
    enunciado TEXT NOT NULL,
    resposta_a TEXT NOT NULL,
    resposta_b TEXT NOT NULL,
    resposta_c TEXT NOT NULL,
    resposta_d TEXT NOT NULL,
    resposta_e TEXT NOT NULL,
    gabarito VARCHAR(1) NOT NULL CHECK (gabarito IN ('A', 'B', 'C', 'D', 'E')),
    materia VARCHAR(20) NOT NULL CHECK (materia IN ('MATEMATICA', 'PORTUGUES')),
    endereco_video TEXT NOT NULL 
);
