# assinante
Aplicação Back-end feita em Spring, utilizando Java 11.

A aplicação consiste em um cadastro de assinantes para envio de e-mails.

Foram feitos os métodos GET, POST e PUT. Para utilizar a aplicação é necessário uma ferramenta para conseguir utilizar esse métodos, como o Postman, um banco de dados em MySQL, utilizando a porta 3306 e ter o usuário root e senha 12345678, sendo o nome do banco springboot. Caso for utilizar outro banco, pode ser modificado o arquivo application.properties em resources.

A primeira tela é uma tela inicial com uma mensagem, ela pode ser acessada pelo link "http://localhost:8080/assinante".

Para cadastro, é necessário utilizar os parâmetros. São obrigatório os parâmetros de email, nome e senha, os opcionais são telefone, cpf e idade.

Exemplo de cadastro: "http://localhost:8080/assinante?nome=Thales&email=thales@gmail.com&senha=123456&idade=24&cpf=00000000000&telefone=45999999999" (POST)

É possível realizar o login utilizando o email e senha. Não foi implementado nada além das validações.

Exemplo de login: "http://localhost:8080/assinante/login?email=thales@gmail.com&senha=123456" (GET)

Como edição de cadastro, foi apenas deixado para conseguir editar o cancelamento/ativação das assinaturas, necessitando o email e senha para poder cancelar ou ativar.

Exemplo de cancelamento: "http://localhost:8080/assinante/cancelarAssinatura?email=thales@gmail.com&senha=123456" (PUT)

Exemplo de ativação: "http://localhost:8080/assinante/ativarAssinatura?email=thales@gmail.com&senha=123456" (PUT)

E foi feito um método GET para retornar apenas o e-mails que estão com a assinatura ativada.

Para ter essa lista, pode-se usar o link: "http://localhost:8080/assinante/listaEmails"

Para esse teste, me foram feitas algumas perguntas, são elas:

Em caso de um assinante cancelado, ele pode voltar a ser assinante e como podemos tratar suas informações?

R: foi utilizado um campo cancelado, onde se o cliente decidir por cancelar a assinatura, o campo é modificado no banco.

Como vamos garantir a autenticidade do e-mail informado?

R: Pode-se utilizar a verificação de e-mail, é mandado um link para verificação no e-mail da pessoa, e ao clicar, é ativado o cadastro. (não implementado)

Como proteger e evitar que o cancelamento de um e-mail seja feito por outra pessoa?

R: Para isso foi utilizado a senha do cliente, porém não foi utilizado nenhuma encriptação para protegimento dos dados, pois como é um projeto pessoal, resolvi deixar apenas salvando no banco.
