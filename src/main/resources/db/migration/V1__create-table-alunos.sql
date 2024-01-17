CREATE TABLE tbl_alunos (
    id_aluno INT PRIMARY KEY AUTO_INCREMENT,
    nome_aluno VARCHAR(255) NOT NULL,
    login VARCHAR(40) NOT NULL UNIQUE,
    data_nascimento DATE NOT NULL,
    cidade VARCHAR(50) NOT NULL,
    email VARCHAR(40) NOT NULL,
    whatsapp VARCHAR(13) NOT NULL,
    data_compra DATE NOT NULL,
    escola_da_prova VARCHAR(40) NOT NULL CHECK (escola_da_prova IN ('CMC', 'CMRJ', 'CMSP', 'CMBel', 'CMBH', 'CMB', 'CMCG', 'CMF', 'CMJF', 'CMM', 'CMPA', 'CMR', 'CMS', 'CMSM'))
);
