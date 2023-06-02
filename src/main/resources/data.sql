-- 1. Carga inicial de dados:

-- Passageiros
INSERT INTO passageiro
    (nome, cpf,data_nascimento, classificacao,milhas )
    VALUES('Rachel Green','000.000.000-00',PARSEDATETIME('01/11/1969','dd/MM/yyyy'),'VIP','100');
INSERT INTO passageiro
    (nome, cpf,data_nascimento, classificacao,milhas )
    VALUES('Phoebe Buffay','111.111.111-11',PARSEDATETIME('30/07/1963','dd/MM/yyyy'),'OURO','100');
INSERT INTO passageiro
    (nome, cpf,data_nascimento, classificacao,milhas )
    VALUES('Ross Geller','222.222.222-22',PARSEDATETIME('02/11/1966','dd/MM/yyyy'),'PRATA','100');
INSERT INTO passageiro
    (nome, cpf,data_nascimento, classificacao,milhas )
    VALUES('Monica Geller','333.333.333-33',PARSEDATETIME('15/06/1964','dd/MM/yyyy'),'OURO','100');
INSERT INTO passageiro
    (nome, cpf,data_nascimento, classificacao,milhas )
    VALUES('Chandler Bing','444.444.444-44',PARSEDATETIME('19/08/1969','dd/MM/yyyy'),'OURO','100');
INSERT INTO passageiro
    (nome, cpf,data_nascimento, classificacao,milhas )
    VALUES('Joey Tribbiani','555.555.555-55',PARSEDATETIME('25/07/1967','dd/MM/yyyy'),'BRONZE','100');
INSERT INTO passageiro
    (nome, cpf,data_nascimento, classificacao,milhas )
    VALUES('Mike Hannigan','666.666.666-66',PARSEDATETIME('06/04/1969','dd/MM/yyyy'),'VIP','100');
INSERT INTO passageiro
    (nome, cpf,data_nascimento, classificacao,milhas )
    VALUES('Gunther Tyler','777.777.777-77',PARSEDATETIME('28/05/1962','dd/MM/yyyy'),'ASSOCIADO','100');
INSERT INTO passageiro
    (nome, cpf,data_nascimento, classificacao,milhas )
    VALUES('Janice Wheeler','888.888.888-88',PARSEDATETIME('07/08/1961','dd/MM/yyyy'),'BRONZE','75');
INSERT INTO passageiro
    (nome, cpf,data_nascimento, classificacao,milhas )
    VALUES('Richard Burke','999.999.999-99',PARSEDATETIME('29/01/1945','dd/MM/yyyy'),'BRONZE','50');

--Assentos

INSERT INTO assento (nome, emergencial) VALUES ('1A', false);
INSERT INTO assento (nome, emergencial) VALUES ('1B', false);
INSERT INTO assento (nome, emergencial) VALUES ('1C', false);
INSERT INTO assento (nome, emergencial) VALUES ('1D', false);
INSERT INTO assento (nome, emergencial) VALUES ('1E', false);
INSERT INTO assento (nome, emergencial) VALUES ('1F', false);
INSERT INTO assento (nome, emergencial) VALUES ('2A', false);
INSERT INTO assento (nome, emergencial) VALUES ('2B', false);
INSERT INTO assento (nome, emergencial) VALUES ('2C', false);
INSERT INTO assento (nome, emergencial) VALUES ('2D', false);
INSERT INTO assento (nome, emergencial) VALUES ('2E', false);
INSERT INTO assento (nome, emergencial) VALUES ('2F', false);
INSERT INTO assento (nome, emergencial) VALUES ('3A', false);
INSERT INTO assento (nome, emergencial) VALUES ('3B', false);
INSERT INTO assento (nome, emergencial) VALUES ('3C', false);
INSERT INTO assento (nome, emergencial) VALUES ('3D', false);
INSERT INTO assento (nome, emergencial) VALUES ('3E', false);
INSERT INTO assento (nome, emergencial) VALUES ('3F', false);
INSERT INTO assento (nome, emergencial) VALUES ('4A', false);
INSERT INTO assento (nome, emergencial) VALUES ('4B', false);
INSERT INTO assento (nome, emergencial) VALUES ('4C', false);
INSERT INTO assento (nome, emergencial) VALUES ('4D', false);
INSERT INTO assento (nome, emergencial) VALUES ('4E', false);
INSERT INTO assento (nome, emergencial) VALUES ('4F', false);
INSERT INTO assento (nome, emergencial) VALUES ('5A', true);
INSERT INTO assento (nome, emergencial) VALUES ('5B', true);
INSERT INTO assento (nome, emergencial) VALUES ('5C', true);
INSERT INTO assento (nome, emergencial) VALUES ('5D', true);
INSERT INTO assento (nome, emergencial) VALUES ('5E', true);
INSERT INTO assento (nome, emergencial) VALUES ('5F', true);
INSERT INTO assento (nome, emergencial) VALUES ('6A', true);
INSERT INTO assento (nome, emergencial) VALUES ('6B', true);
INSERT INTO assento (nome, emergencial) VALUES ('6C', true);
INSERT INTO assento (nome, emergencial) VALUES ('6D', true);
INSERT INTO assento (nome, emergencial) VALUES ('6E', true);
INSERT INTO assento (nome, emergencial) VALUES ('6F', true);
INSERT INTO assento (nome, emergencial) VALUES ('7A', false);
INSERT INTO assento (nome, emergencial) VALUES ('7B', false);
INSERT INTO assento (nome, emergencial) VALUES ('7C', false);
INSERT INTO assento (nome, emergencial) VALUES ('7D', false);
INSERT INTO assento (nome, emergencial) VALUES ('7E', false);
INSERT INTO assento (nome, emergencial) VALUES ('7F', false);
INSERT INTO assento (nome, emergencial) VALUES ('8A', false);
INSERT INTO assento (nome, emergencial) VALUES ('8B', false);
INSERT INTO assento (nome, emergencial) VALUES ('8C', false);
INSERT INTO assento (nome, emergencial) VALUES ('8D', false);
INSERT INTO assento (nome, emergencial) VALUES ('8E', false);
INSERT INTO assento (nome, emergencial) VALUES ('8F', false);
INSERT INTO assento (nome, emergencial) VALUES ('9A', false);
INSERT INTO assento (nome, emergencial) VALUES ('9B', false);
INSERT INTO assento (nome, emergencial) VALUES ('9C', false);
INSERT INTO assento (nome, emergencial) VALUES ('9D', false);
INSERT INTO assento (nome, emergencial) VALUES ('9E', false);
INSERT INTO assento (nome, emergencial) VALUES ('9F', false);
INSERT INTO assento (nome, emergencial) VALUES ('10A', false);
INSERT INTO assento (nome, emergencial) VALUES ('10B', false);
INSERT INTO assento (nome, emergencial) VALUES ('10C', false);
INSERT INTO assento (nome, emergencial) VALUES ('10D', false);
INSERT INTO assento (nome, emergencial) VALUES ('10E', false);
INSERT INTO assento (nome, emergencial) VALUES ('10F', false);

