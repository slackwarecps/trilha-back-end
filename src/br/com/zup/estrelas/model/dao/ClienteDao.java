package br.com.zup.estrelas.model.dao;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Persistence;
import br.com.zup.estrelas.model.domain.Cliente;


public class ClienteDao {

    EntityManager manager;

    public ClienteDao() {
        this.manager = Persistence.createEntityManagerFactory("clientes").createEntityManager();
    }
    public List<Cliente> getClientes() throws SQLException, ClassNotFoundException {

        return clientes;
    }

    public void salvar(Cliente cliente) throws SQLException, ClassNotFoundException {
        clientes.add(cliente);
    }

    public void excluir(String cpf) throws SQLException, ClassNotFoundException {
        for (int i = 0; i < clientes.size(); i++) {

            if (cpf.equals(clientes.get(i).getCpf())) {
                clientes.remove(clientes.get(i));
                return;
            }
        }
    }

    public Cliente getClienteId(String cpf)
            throws IllegalArgumentException, SQLException, ClassNotFoundException {
        for (int i = 0; i < clientes.size(); i++) {

            if (clientes.get(i).getCpf().equals(cpf)) {
                return clientes.get(i);
            }
        }
        throw new IllegalArgumentException("Nao achou cliente para o cpf " + cpf);
    }

    public void atualizar(Cliente cliente) {
        Cliente clienteAlterado = new Cliente();


        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getCpf().equals(cliente.getCpf())) {
                clienteAlterado = clientes.get(i);

                clienteAlterado.setEmail(cliente.getEmail());
                clienteAlterado.setNome(cliente.getNome());
                clienteAlterado.setIdade(cliente.getIdade());
                clienteAlterado.setTelefone(cliente.getTelefone());
                clienteAlterado.setEndereco(cliente.getEndereco());
                clienteAlterado.setCpf(cliente.getCpf());

                clientes.remove(clientes.get(i));
                clientes.add(clienteAlterado);

                return;
            }
        }
    }

    public boolean cpfCadastrado(String cpf) {
        for (int i = 0; i < clientes.size(); i++) {

            if (clientes.get(i).getCpf().equals(cpf)) {
                clientes.get(i);
                return false;
            }
        }
        return true;
    }
}
