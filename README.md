# 🎬 Sistema de Cadastro de Filmes

Este é um sistema simples de cadastro de filmes desenvolvido em **Java**, que permite ao usuário:

- Cadastrar filmes com informações como nome, diretor, data de lançamento, gênero e custo de produção.
- Remover filmes pelo nome.
- Listar todos os filmes cadastrados, ordenados por data de lançamento.
- Verificar se o filme já foi lançado, ainda será lançado ou se estreia hoje.

## 🧾 Funcionalidades

1. **Cadastrar Filme**
2. **Remover Filme**
3. **Listar Filmes**
4. **Sair**

Ao listar os filmes, o sistema também mostra:
- Status do lançamento (já lançado, ainda será lançado ou estreia hoje).
- Informações detalhadas do filme.

## 📦 Estrutura do Projeto

```
src/
├── application/
│   └── Program.java             # Classe principal com o menu e lógica principal
├── entities/
│   └── Movie.java               # Classe que representa o filme
└── entities/enums/
    └── FilmGenre.java           # Enum com diversos gêneros de filmes
```

## 🎭 Gêneros Suportados

O gênero do filme deve ser informado em **inglês**. O sistema aceita nomes com espaços, como:

- `science fiction`
- `dark comedy`
- `slice of life`

O programa automaticamente converte isso para o formato compatível com o enum:
- `SCIENCE_FICTION`
- `DARK_COMEDY`
- `SLICE_OF_LIFE`

✅ **Ou seja, você pode digitar com espaço que o sistema se adapta!**

## 🛠️ Tecnologias Utilizadas

- Java 17+
- API de Datas (`java.time.LocalDate`)
- Coleções (`ArrayList`, `Collections.sort`, `Comparator`)
- Enumeração (`enum`)

## 📋 Exemplo de Uso

```
- Sistema de Cadastro de Filmes -
1 - Cadastrar Filme
2 - Remover Filme
3 - Listar Filmes
4 - Sair
```

## 📌 Observações

- O sistema ordena os filmes automaticamente por data de lançamento ao cadastrar.
- A remoção é feita buscando o nome do filme (sem diferenciar maiúsculas e minúsculas).
- O status do lançamento é baseado na data atual do sistema.
