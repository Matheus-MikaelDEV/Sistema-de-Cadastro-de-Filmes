package application;

import entities.Movie;
import entities.enums.FilmGenre;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("- Sistema de Cadastro de Filmes -");

        int option = 0;

        List<Movie> listaFilmes = new ArrayList<Movie>();

        do {
            System.out.println("Qual opção deseja?");
            System.out.println("1 - Cadastrar Filme\n2 - Remover Filme\n3 - Listar Filmes\n4 - Sair");
            System.out.print("Opção: ");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Nome do filme: ");
                    String nome = sc.nextLine();
                    System.out.print("Nome do diretor: ");
                    String diretor = sc.nextLine();
                    System.out.print("Custo de produção: ");
                    double custo = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Genero do filme(em inglês): ");
                    String genero = sc.nextLine().toUpperCase().replace(" ", "_");
                    System.out.print("Data de lançamento(dd/mm/yyyy): ");
                    String dataLancamento = sc.nextLine();

                    LocalDate dataLancamentoDate = LocalDate.parse(dataLancamento, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    FilmGenre filmGenre = FilmGenre.valueOf(genero);

                    Movie filme = new Movie(nome, dataLancamentoDate, diretor, filmGenre, custo);
                    listaFilmes.add(filme);

                    Collections.sort(listaFilmes, Comparator.comparing(Movie::getYearRelease));
                    break;
                case 2:
                    String nomeParaRemover = "";
                    if (listaFilmes.isEmpty()) {
                        System.out.println("Nenhum Filme cadastrado...");
                    } else {
                        System.out.print("Nome do filme: ");
                        nomeParaRemover = sc.nextLine();
                        boolean encontrado = false;

                        for (int i = 0; i < listaFilmes.size(); i++) {
                            if (listaFilmes.get(i).getTitle().equalsIgnoreCase(nomeParaRemover)) {
                                listaFilmes.remove(i);
                                encontrado = true;
                                System.out.println("Filme removido com sucesso!");
                            }
                        }

                        if (!encontrado) {
                            System.out.println("Filme não encontrado!");
                        }
                    }
                    break;
                case 3:
                    int i = 0;
                    if (listaFilmes.isEmpty()) {
                        System.out.println("Nenhum Filme cadastrado...");
                    } else {
                        for (Movie movie : listaFilmes) {
                            String status;

                            if (movie.getYearRelease().isBefore(LocalDate.now())) {
                                status = " já foi lançado.";
                            } else if (movie.getYearRelease().isAfter(LocalDate.now())) {
                                status = " ainda não foi lançado.";
                            } else {
                                status = " lança hoje!";
                            }

                            System.out.println("\nFilme número " + (i + 1) + status);
                            System.out.println("Nome: " + movie.getTitle());
                            System.out.println("Data de lançamento: " + movie.getYearRelease().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                            System.out.println("Diretor: " + movie.getDirector());
                            System.out.println("Gênero: " + movie.getGenre());
                            System.out.println("Custo de produção: R$" + movie.getProductionCost());
                            i++;
                        }
                    }
                    i = 0;
                    break;
                case 4:
                    System.out.println("Fechando o programa...");
            }
        } while (option != 4);
    }
}