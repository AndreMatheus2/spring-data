package br.com.andre.spring.data.service;

import br.com.andre.spring.data.orm.Funcionario;
import br.com.andre.spring.data.orm.FuncionarioProjecao;
import br.com.andre.spring.data.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

@Service
public class RelatoriosService {

    private Boolean system = true;
private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private FuncionarioRepository funcionarioRepository;

    public RelatoriosService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public void inicial(Scanner scanner) {
        while (system) {
            System.out.println("Qual ação você quer executar ?");
            System.out.println("0 - Sair");
            System.out.println("1 - Busca Funcionaro nome");
            System.out.println("2 - Busca Funcionaro nome, data, salario maior");
            System.out.println("3 - Pesquisa Funcionario, SALARIO");


            int action = scanner.nextInt();
            switch (action) {
                case 1:
                    buscaFuncionario(scanner);
                    break;
                    case 2:
                        buscaFuncionarioNomeSalarioMaiorData(scanner);
                    break;
                    case 3:
                        pesquisaFuncionarioSalario();
                    break;
                default:
                    system = false;
                    break;
            }
        }
    }

    private void buscaFuncionario(Scanner scanner){
        System.out.println("Qual nome deseja pesquisar");
        String nome = scanner.next();
        List<Funcionario> list = funcionarioRepository.findByNome(nome);
        list.forEach(System.out::println);
    }

    private void buscaFuncionarioNomeSalarioMaiorData(Scanner scanner){
        System.out.println("nome:");
        String nome = scanner.next();

        System.out.println("data:");
        String data = scanner.next();
        LocalDate localDate = LocalDate.parse(data, formatter);

        System.out.println("salario:");
        Double salario = scanner.nextDouble();

        List<Funcionario> list = funcionarioRepository.findNomeSalarioMaiorDataContratacao(nome, salario, localDate);
        list.forEach(System.out::println);
    }

    private void pesquisaFuncionarioSalario(){
        List<FuncionarioProjecao> list = funcionarioRepository.findFuncionarioSalario();
        list.forEach(f -> System.out.println("Funcionario: | ID: " + f.getId() + " | NOME: " + f.getNome() + " | SALARIO: " + f.getSalario()));
    }
}