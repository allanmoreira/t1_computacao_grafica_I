import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Allan Moreira on 30/08/17.
 */
public class LeituraArquivo {

    private static final String CAMINHO_PROJETO = System.getProperty("user.dir") + "/src/arquivos/";;
    private File arquivo;
    private final char SEPARADOR_DE_EXTENSAO = '.';
    private int frame;
    private int maxX, maxY;
    private int qtdPessoas;
   
    
    public LeituraArquivo(ArquivosDataSet arquivosDataSet){
        arquivo = new File(CAMINHO_PROJETO + arquivosDataSet.toString());
    }

    public ArrayList<Pessoa> ler() {
        ArrayList<Pessoa> listaPessoas = new ArrayList<>();

        try {
            // Abre o arquivo
            FileReader f = new FileReader(arquivo);
            BufferedReader buf = new BufferedReader(f);
            try {
                String line;
                String[] str;
                Queue<Coordenada> filaCoordenadas;
                // Le as informacoes do arquivo (uma linha por vez)
                while ((line = buf.readLine()) != null) {
                    Pessoa pessoa = new Pessoa();
                    filaCoordenadas = new LinkedList<Coordenada>();

                    // Pula a primeira linha, que informa o número de pixels equivalente na conversão de dados
                    if(line.contains("[")) {
                        continue;
                    }

                    // Pega o número que indica que é uma nova pessoa, com a quantidade de movimentos da mesma
                    int indiceTab = line.lastIndexOf("\t");
                    int qtdeMovimentosPessoa = Integer.parseInt(line.substring(0, indiceTab));
                    pessoa.setQtdeMovimentos(qtdeMovimentosPessoa);

                    // Deixa na string somente os valores das coordenadas
                    line = line.substring(indiceTab+1, line.length());
                    str = line.split("[\\(\\)]");
                    for (String s : str) {
                        // Caso a linha esteja vazia, não a adiciona ao array
                        if(!"".equals(s)) {
                            String[] pos = s.split(",");
                            int x = Integer.parseInt(pos[0]);
                            int y = Integer.parseInt(pos[1]);
                            int temp = Integer.parseInt(pos[2]);
                            Coordenada coordenada = new Coordenada(x, y, temp);
                            filaCoordenadas.add(coordenada);
                           
                            if(frame<temp) { //buscar o ultimo frame do video
                            	frame=temp;
                            }                            
                            
                            if(x > maxX)
                            	maxX = x;
                            if(y > maxY)
                            	maxY = y;
                        }
                    }
                    // Adiciona a lista de coordenadas referente à pessoa
                    pessoa.setFilaCoordenadas(filaCoordenadas);
                    listaPessoas.add(pessoa);
                }
            } finally {
                // Fecha o arquivo
                f.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listaPessoas;
    }

    public String getNomeArquivo() {
        String caminhoCompletoArquivo = arquivo.getAbsolutePath();
        int indiceSeparador = caminhoCompletoArquivo.lastIndexOf(File.separator);
        return caminhoCompletoArquivo.substring(indiceSeparador+1, caminhoCompletoArquivo.length());
    }

	public int getMaxX() {
		return maxX;
	}

	public int getMaxY() {
		return maxY;
	}

	public int getFrame() {
		return frame;
	}

	public void setFrame(int frame) {
		this.frame = frame;
	}
    
    
}