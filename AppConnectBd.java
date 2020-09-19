package segundoPeriodo.bd_dio;

import java.util.List;
import java.util.Scanner;

public class AppConnectBd {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        AlunoDAO alunoDAO =  new AlunoDAO();
        List<Aluno> alunos = alunoDAO.list();
        byte opcao = 0;
        System.out.print("1 - Listagem\n2 - Consulta\n3 - Inserir\n4 - Delete\n5 - Alterar\n");
        System.out.print("Entre com opção: ");
        opcao = sc.nextByte();

        if (opcao == 1){
            // 1 - Consulta
            alunos.stream().forEach(System.out::println);
        } else if (opcao == 2){
            //2 - Consulta com filtro
            Aluno alunoParaConsulta = alunoDAO.consularId(3);
            System.out.println(alunoParaConsulta);
        } else if (opcao == 3){
            //3 - inserir dados
        Aluno aluno = new Aluno(
                "Rui",
                "Rua 31",
                "PE"
        );
        alunoDAO.create(aluno);
        } else if (opcao == 4){
            //4 - delete
            alunoDAO.list().stream().forEach(System.out::println);
            alunoDAO.delete(7);
            alunoDAO.list().stream().forEach(System.out::println);
        } else if (opcao == 5){

            alunoDAO.list().stream().forEach(System.out::println);

            Aluno atualizarAluno = alunoDAO.consularId(3);
            atualizarAluno.setNome("Guto");
            atualizarAluno.setEndereco("Eua Campos");
            atualizarAluno.setEstado("PE");

            alunoDAO.update(atualizarAluno);

            alunoDAO.list().stream().forEach(System.out::println);
        }
    }
}
