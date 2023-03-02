# To Do Tarefs

Uma API para o sistema de lista de tarefas


## EndPoins
- Tarefas
    - [Criar tarefa](#criar-tarefa)
    - Atualizar tarefa
    - Excluír tarefa
    - [Visualizar tarefa/tarefas](#visualizar-tarefas)

- Categorias
 - Criar Categoria
    - Atualizar Categoria
    - Excluír Categoria
    - Visualizar Categoria/Categorias

### Criar tarefa
`POST`/todotarefs/api/tarefa

| campo | tipo | obrigatório | descrição
|-------|------|-------------|----------
| titulo | String | sim | Local onde será definido o titulo da atividade
| categoria_id | int | sim | é o id de uma categoria previmente cadastrada
| descrição | String | não | é onde será colocado a descrição da tarefa
| data | data | sim | marcação da data dessa tarefa ou até onde ela será valida



***Exemplo de corpo de request**

```
{
    "titulo": "Fazer compra da semana",
    "categoria_id": 1,
    "descricao":"Compra semanal",
    "data":"2023-04-24",

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


{
    "titulo": "Fazer compra da semana",
    "categoria": {
        "categoria_id": 1,
        "nome":"tarefa recorrente semanal"
    }
    "descricao":"Compra semanal",
    "data":"2023-04-24",

}
```

**Código de Resposta**

| código | descrição 
|-|-
| 201 | tarefa cadastrada com sucesso
| 400 | erro na validação dos dados