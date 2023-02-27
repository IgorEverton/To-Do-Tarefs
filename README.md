# To Do Tarefs

Uma API para o sistema de lista de tarefas


## EndPoins
- Tarefas
    - [Criar tarefa](#criar-tarefa)
<<<<<<< HEAD
    - [Atualizar tarefa](#atualizar-tarefas)
    - [Excluír tarefa](#deletar-tarefas)
    - [Visualizar tarefa/tarefas](#visualizar-tarefas)

- Categorias
    - [Criar Categoria](#cadastrar-categoria)
    - [Atualizar Categoria](#atualizar-categoria)
    - [Excluír Categoria](#deletar-categoria)
    - [Visualizar Categoria/Categorias](#deletar-categoria-1)
    - [Atualizar categoria](#visualizar-categoria)


- Usuário
    - criar Usuario
    - atualizar Usuario
    - ver usuário
    - deletar usuário
=======
    - Atualizar tarefa
    - Excluír tarefa
    - [Visualizar tarefa/tarefas](#visualizar-tarefas)

- Categorias
 - Criar Categoria
    - Atualizar Categoria
    - Excluír Categoria
    - Visualizar Categoria/Categorias
>>>>>>> 95cf00b (documentação da api versão inicial)

### Criar tarefa
`POST`/todotarefs/api/tarefa

| campo | tipo | obrigatório | descrição
|-------|------|-------------|----------
| titulo | String | sim | Local onde será definido o titulo da atividade
<<<<<<< HEAD
| categoria_id | int | sim | é o id de uma categoria previmente cadastrada
| descrição | String | não | é onde será colocado a descrição da tarefa
| data | data | sim | marcação da data dessa tarefa ou até onde ela será valida
| id | int | sim | id da tarefa e será incrementado no sgbd
=======

| categoria_id | int | sim | é o id de uma categoria previmente cadastrada

| descrição | String | não | é onde será colocado a descrição da tarefa

| data | data | sim | marcação da data dessa tarefa ou até onde ela será valida
>>>>>>> 95cf00b (documentação da api versão inicial)



***Exemplo de corpo de request**

```
<<<<<<< HEAD
{   
    "id":1,
    "titulo": "Fazer compra da semana",
    "categoria": 1,
    "descricao":"Compra semanal",
    "data":"24/02/2023"
=======
{
    "titulo": "Fazer compra da semana",
    "categoria_id": 1,
    "descricao":"Compra semanal",
    "data":"2023-04-24",

>>>>>>> 95cf00b (documentação da api versão inicial)
}

```


**Código de Resposta**

| código | descrição 
|-|-
| 201 | tarefa cadastrada com sucesso
| 400 | erro na validação dos dados



### Visualizar Tarefas
`GET`/todotarefs/api/tarefa/{id}

```js

<<<<<<< HEAD
{
    "titulo": "Fazer compra da semana",
    "categoria": 1,
    "descricao":"Compra semanal",
    "data":"24/02/2023"
=======

{
    "titulo": "Fazer compra da semana",
    "categoria": {
        "categoria_id": 1,
        "nome":"tarefa padrão"
    }
    "descricao":"Compra semanal",
    "data":"2023-04-24",

>>>>>>> 95cf00b (documentação da api versão inicial)
}
```

**Código de Resposta**

| código | descrição 
|-|-
| 201 | tarefa cadastrada com sucesso
<<<<<<< HEAD
| 400 | erro na validação dos dados

### deletar Tarefas
`delete`/todotarefs/api/tarefa/{id}

```js

```

**Código de Resposta**

| código | descrição 
|-|-
| 204 | no content
| 400 | 


### Atualizar Tarefas
`put`/todotarefs/api/tarefa/{id}

```js
    
{
    "titulo":"fazer conpra diaria",
    "descricao":"comprar diaria pra fazer o jantar"
    "data":"30/04/2023"
}

```

**Código de Resposta**

| código | descrição 
|-|-
| 200 | ok
| 400 | 






- Categoria



| campo | tipo | obrigatório | descrição
|-------|------|-------------|----------
| titulo | String | sim | Local onde será definido o titulo da atividade
| id | int | sim | é o id de uma categoria, gerá automaticamente pelo sgbd
| descrição | String | não | é onde será colocado a descrição da Categoria
| Tarefas | Tarefas | não | é onde será colocado as tarefas que pertecem a categoria




### Visualizar Categoria
`GET`/todotarefs/api/categoria/{id}

```js


{
	"id":1,
	"nome":"Eescola",
	"descricao":"Conter anotações sobre a escola",
	"tarefas":{
		"anotacao1":{
			"titulo":"lista de material escolar",
			"categoria_id":1,
			"descricao":"caneta,caderno,borracha,lápis",
			"data":"12/01/2023"
		},
			"anotacao2":{
			"titulo":"lista de provas semana que vem",
			"categoria_id":1,
			"descricao":"QA,java,PQ/SQL",
			"data":"14/03/2023"
		},
	}
}
```

**Código de Resposta**

| código | descrição 
|-|-
| 200 | ok (dados retornados)
| 404 | Não encontrado

### Cadastrar Categoria
`POST`/todotarefs/api/categoria/

```js

{
	"id":2,
	"nome":"academia",
	"descricao":"anotações dos meus treinos na academia",
	"tarefas":null
}
```

**Código de Resposta**

| código | descrição 
|-|-
| 201 | CRIADO
| 400 | Não encontrado


### deletar Categoria
`delete`/todotarefs/api/categoria/{id}

```js

```

**Código de Resposta**

| código | descrição 
|-|-
| 204 | NO CONTENT
| 400 | 

### Atualizar Categoria
`put`/todotarefs/api/categoria/{id}

```js
{
    "nome":"Faculdade",
    "descricao":"conteudo sobre o curso"

}
```

**Código de Resposta**

| código | descrição 
|-|-
| 200 | ok
| 400 | 



-USUÁRIO

| campo | tipo | obrigatório | descrição
|-------|------|-------------|----------
| Nome | String | sim | Nome do usuário
| id | int | sim | é o id do usuário que será auto incrementado no sgbd
| nasciemnto | date | sim | é onde será colocado a data de nascimento do usuário
| email | String | sim | Será armazenado o endereço de email do usuário.
| telefone | string | não | Será armazenado um número de telefone.
| status | boolean | sim | Será armazenado a situação do usuário se a conta está ativa ou não(true,false).


### Visualizar Usuario
`GET`/todotarefs/api/usuario/{id}

```js


{
    "id":1,
    "nome":"Luke kane",
    "nascimento":"12/03/1992",
    "email":"lukeKane932@hotmail.com",
    "telefone":"2198323821",
    "status":true
}
```

**Código de Resposta**

| código | descrição 
|-|-
| 200 | ok (dados retornados)
| 404 | Não encontrado

### Cadastrar Usuario
`POST`/todotarefs/api/usuario/

```js

{
    "id":2,
    "nome":"Victor Ramos",
    "nascimento":"11/08/2002",
    "email":"vramos032@gmail.com",
    "telefone":"1143323821",
}
```

**Código de Resposta**

| código | descrição 
|-|-
| 201 | CRIADO
| 400 | Não encontrado

### deletar Categoria
`delete`/todotarefs/api/usuario/{id}

```js

```

**Código de Resposta**

| código | descrição 
|-|-
| 204 | NO CONTENT
| 400 | 


### Atualizar Categoria
`put`/todotarefs/api/usuario/{id}

```js
{
   
    "nome":"Victor Ramos Candido",
    "nascimento":"11/08/2002",
    "email":"vramos032@gmail.com",
    "telefone":"1143323821",

}
```

**Código de Resposta**

| código | descrição 
|-|-
| 200 | ok
| 400 | 

=======
| 400 | erro na validação dos dados
>>>>>>> 95cf00b (documentação da api versão inicial)
