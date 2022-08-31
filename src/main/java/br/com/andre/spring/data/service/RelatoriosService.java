package br.com.andre.spring.data.service;

import br.com.andre.spring.data.orm.Funcionario;
import br.com.andre.spring.data.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class RelatoriosService {

    private Boolean system = true;

    private FuncionarioRepository funcionarioRepository;

    public RelatoriosService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public void inicial(Scanner scanner) {
        while (system) {
            System.out.println("Qual ação você quer executar ?");
            System.out.println("0 - Sair");
            System.out.println("1 - Busca Funcionaro nome");


            int action = scanner.nextInt();
            switch (action) {
                case 1:
                    buscaFuncionario(scanner);
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
}