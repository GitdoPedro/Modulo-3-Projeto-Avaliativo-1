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

INSERT INTO assento(nome,emergencial) VALUES('1A',false);
