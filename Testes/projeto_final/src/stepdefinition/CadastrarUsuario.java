package stepdefinition;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import util.ComidasFavoritas;
import util.Escolaridades;
import util.Esportes;
import util.Sexos;

public class CadastrarUsuario {
    util.CadastrarUsuario componentes = new util.CadastrarUsuario();

    @Dado("que o usuário acessou a página Campo de treinamento")
    public void queOUsuárioAcessouAPáginaCampoDeTreinamento() {
        componentes.inicializa();
    }

    @Dado("que o usuário preencheu o campo nome")
    public void queOUsuárioPreencheuOCampoNome() {
        componentes.preencherCampoNome("Felipe");
    }

    @E("preencheu o campo sobrenome")
    public void preencheuOCampoSobrenome() {
        componentes.preencherCampoSobrenome("Ticiani");
    }

    @E("preencheu o campo sexo")
    public void preencheuOCampoSexo() {
        componentes.preencherCampoSexo(Sexos.MASCULINO);
    }

    @E("preencheu o campo comida favorita")
    public void preencheuOCampoComidaFavorita() {
        componentes.preencherCampoComidaFavorita(ComidasFavoritas.PIZZA);
    }

    @E("prencheu o campo escolaridade")
    public void prencheuOCampoEscolaridade() {
        componentes.preencherCampoEscolaridade(Escolaridades.SUPERIOR);
    }

    @E("preencheu o campo esportes")
    public void preencheuOCampoEsportes() {
        componentes.preencherCampoEsporte(Esportes.O_QUE_EH_ESPORTE);
    }

    @Quando("clicar no botão Cadastrar")
    public void clicarNoBotãoCadastrar() {
        componentes.clicarEmCadastrar();
    }

    @Então("as informações cadastradas devem ser exibidas")
    public void asInformaçõesCadastradasDevemSerExibidas() {
        componentes.verificarInformacoesCadastradas("Felipe", "Ticiani", Sexos.MASCULINO, ComidasFavoritas.PIZZA, Escolaridades.SUPERIOR, Esportes.O_QUE_EH_ESPORTE);
        componentes.fecharNavegador();
    }

    @Dado("que o usuário não preencheu o campo Nome")
    public void queOUsuárioNãoPreencheuOCampoNome() {
        componentes.preencherCampoNome("");
    }

    @Então("deve exibir um alerta informando que o campo Nome é obrigatório")
    public void deveExibirUmAlertaInformandoQueOCampoNomeÉObrigatório() {
        componentes.verificarAlertaCampoObrigatorio("Nome");
        componentes.fecharNavegador();
    }

    @Dado("que o usuário não preencheu o campo Sobrenome")
    public void queOUsuárioNãoPreencheuOCampoSobrenome() {
        componentes.preencherCampoNome("Felipe");
        componentes.preencherCampoSobrenome("");
    }

    @Então("deve exibir um alerta informando que o campo Sobrenome é obrigatório")
    public void deveExibirUmAlertaInformandoQueOCampoSobrenomeÉObrigatório() {
        componentes.verificarAlertaCampoObrigatorio("Sobrenome");
        componentes.fecharNavegador();
    }

    @Dado("que o usuário não preencheu o campo Sexo")
    public void queOUsuárioNãoPreencheuOCampoSexo() {
        componentes.preencherCampoNome("Felipe");
        componentes.preencherCampoSobrenome("Ticiani");
    }

    @Então("deve exibir um alerta informando que o campo Sexo é obrigatório")
    public void deveExibirUmAlertaInformandoQueOCampoSexoÉObrigatório() {
        componentes.verificarAlertaCampoObrigatorio("Sexo");
        componentes.fecharNavegador();
    }
}
