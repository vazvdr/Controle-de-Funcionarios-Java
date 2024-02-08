
package data;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
//Essa é a classe que faz a conexao com o banco de dados
//Observe que dentro dos métodos dessa classe sempre chamo os getters para pegar os valores armazenados na memoria
//atraves dos métodos setters
public class FuncionarioDao {
    //variaveis globais que posso chamar dentro de qualquer método
    Connection conexao;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<Funcionario> lista = new ArrayList<>();
    
    public Connection conectar(){
        try{
            conexao = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/javateste","rootjava","rootjava");
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Não foi possível conectar no Banco de Dados");
        }
        return conexao;
    }
    public void cadastrar(Funcionario funcionario){
        String sql = "INSERT INTO funcionario VALUES(?,?,?,?,?,?,?,?)";
        conexao = new FuncionarioDao().conectar();
        try {
             pstm = conexao.prepareStatement(sql);
             pstm.setInt(1, funcionario.getMatricula());
             pstm.setString(2, funcionario.getNome());
             pstm.setString(3, funcionario.getCargo());
             pstm.setDouble(4, funcionario.getSalario());
             pstm.setString(5, funcionario.getNascimento());
             pstm.setString(6, funcionario.getCPF());
             pstm.setString(7, funcionario.getEmail());
             pstm.setString(8, funcionario.getSetor());
             pstm.execute();
             pstm.close();
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Funcionário não cadastrado!");
        }        
        }
    public ArrayList<Funcionario> pesquisar(){
        String pesquisar = "SELECT * from funcionario ORDER BY matricula";
        conexao = new FuncionarioDao().conectar();
        try{
            pstm = conexao.prepareStatement(pesquisar);
            rs=pstm.executeQuery();
            while(rs.next()){
                Funcionario funcionario = new Funcionario();
                funcionario.setMatricula(rs.getInt("matricula"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setSalario(rs.getDouble("salario"));
                funcionario.setNascimento(rs.getString("nascimento"));
                funcionario.setCPF(rs.getString("cpf"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setSetor(rs.getString("setor"));
                lista.add(funcionario);
            }
            } catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Erro no comando SQL para listar tabela");
            }
            return lista;
        }
    public void alterar(Funcionario funcionario){
        String alterar = "UPDATE funcionario set nome = ?, cargo = ?, salario = ?, nascimento = ?, cpf = ?, email = ?, setor = ? WHERE matricula = ?";
        conexao = new FuncionarioDao().conectar();
        try{
            pstm = conexao.prepareStatement(alterar);
            pstm.setString(1, funcionario.getNome());
            pstm.setString(2, funcionario.getCargo());
            pstm.setDouble(3, funcionario.getSalario());
            pstm.setString(4, funcionario.getNascimento());
            pstm.setString(5, funcionario.getCPF());
            pstm.setString(6, funcionario.getEmail());
            pstm.setString(7, funcionario.getSetor());
            pstm.setInt(8, funcionario.getMatricula());
            pstm.execute();
            pstm.close();
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Os dados não foram alterados!");
        }
    }
    public void excluir(Funcionario funcionario){
        String excluir = "DELETE from funcionario WHERE matricula = ?";
        conexao = new FuncionarioDao().conectar();
        try{
            pstm = conexao.prepareStatement(excluir);
            pstm.setInt(1, funcionario.getMatricula());
            pstm.execute();
            pstm.close();
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Funcionário não excluído");
        }
    }
    }

