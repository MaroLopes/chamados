/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.BEAN;

import br.com.chamados.DAO.ChamadoDAO;
import br.com.chamados.VO.Chamado;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author mlopes
 */
@ManagedBean (name="chamadoBEAN")
@RequestScoped
public class ChamadoBEAN implements java.io.Serializable {

    /**
     * Creates a new instance of ChamadoBEAN
     */
    public ChamadoBEAN() {
        data1 = new Date();
    }
    
    private Date data1;
    private Chamado chamado = new Chamado();  
    private List<Chamado> chamados;
    private List<Chamado> selectedChamados;
    private String teste;
    

    public String getTeste() {
        return teste;
    }

    public void setTeste(String teste) {
        this.teste = teste;
    }
    
    public Date getData1() {
        return data1;
    }

    public void setData1(Date data1) {
        this.data1 = data1;
    }

    public Chamado getChamado() {
        return chamado;
    }

    public void setChamado(Chamado chamado) {
        this.chamado = chamado;
    }

    public List<Chamado> getSelectedChamados() {
        return selectedChamados;
    }

    public void setSelectedChamados(List<Chamado> selectedChamados) {
        this.selectedChamados = selectedChamados;
    }
 
    
    
    public List<Chamado> getChamados() {
        
        ChamadoDAO dao = new ChamadoDAO();
                
        try {
            
            List<Chamado> lista = dao.GetData(data1);
            chamados = lista;
        } catch (Exception e) {
            
        }
        return chamados;
    }
    
    
    
    public void addChamado(){
        
        try {
            
            ChamadoDAO dao = new ChamadoDAO();
            dao.salvar(chamado);
            RequestContext.getCurrentInstance().closeDialog(this);
//            sendMail(chamado);
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro:", "Agendamento Cadastrada com sucesso!"));
        } catch (Exception e) {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", e.toString()));
        } 
        
    }
    
    public void deleteChamado(){
        
        try {
            if (selectedChamados.isEmpty()) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Deleta:", "Selecione chamados para deleta-los"));
            }else{
                for (Chamado c : selectedChamados) {
                    ChamadoDAO dao = new ChamadoDAO();
                    dao.delete(c);
                }
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Deletados:", "Chamados selecionados deletados com sucesso!"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Deletados Error!", e.getMessage()));
        }
        
    }
    
    public void updateAgenda(){
        
        try {
            
            ChamadoDAO dao = new ChamadoDAO();
            dao.update(chamado);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização:", "Agenda atualizada com sucesso!"));
        } catch (Exception e) {
            
        }
        
    }
    
    public void novoChamado() {
        Map<String,Object> options = new HashMap<String, Object>();
        options.put("resizable", true);
        options.put("draggable", true);
        options.put("modal", true);
        options.put("width", 640);
        options.put("height", 550);
        options.put("closable", false);
        options.put("contentWidth", "100%");
        options.put("contentHeight", "100%");
        chamado = new Chamado();
        RequestContext.getCurrentInstance().openDialog("chamado/form_novo_chamado", options, null);
        
    }
    
    public void editarChamado() {
        Map<String,Object> options = new HashMap<String, Object>();
        options.put("resizable", true);
        options.put("draggable", true);
        options.put("modal", true);
        options.put("width", 640);
        options.put("height", 550);
        options.put("closable", false);
        options.put("contentWidth", "100%");
        options.put("contentHeight", "100%");
        
        
        if (selectedChamados.size() == 1) {
            chamado = selectedChamados.get(0);
            RequestContext.getCurrentInstance().openDialog("chamado/form_novo_chamado", options, null);
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Selecionar:", "Selecione uma Agenda a ser Editada!"));
        }
        
    }
    
    public void filtroDataTable(SelectEvent e) {
        
        data1 = (Date)e.getObject();
        
    }
    
        public void closeDialog() {
        RequestContext.getCurrentInstance().closeDialog(this);
    }
    
//    public void sendMail(Agenda a) throws EmailException{
//        SimpleEmail email = new SimpleEmail();
//        //Utilize o hostname do seu provedor de email
//        email.setHostName("mail.ensel.com.br");
//        //Quando a porta utilizada não é a padrão (gmail = 465)
//        email.setSmtpPort(26);
//        //Adicione os destinatários
//        email.addTo("corporativo.spo@ensel.com.br", "Corporativo - SPO");
//        //Configure o seu email do qual enviará
//        email.setFrom("corporativo.spo@ensel.com.br", "Corporativo - SPO");
//        //Adicione um assunto
//        email.setSubject("(Teste Aplicação) - Chamado " + a.getAgendaId() + "- Data " + formatarData(a.getAgendaData()) + " - Hora " + formatarHora(a.getAgendaHora())
//                + " - Projeto " + a.getAgendaProjetoId() + " - " + a.getAgendaSolicitante() + " - " + a.getAgendaCidade() + " - " + a.getAgendaUf());
//        //Adicione a mensagem do email
//        email.setMsg(a.getAgendaDescricaoAtividade());
//        //Para autenticar no servidor é necessário chamar os dois métodos abaixo
//        email.setSSL(false);
//        email.setAuthentication("corporativo.spo@ensel.com.br", "dwm=11");
////        System.out.println("enviando...");
//        email.send();
////        System.out.println("Email enviado!");
//    }
    
    public String formatarData(Date d) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return formato.format(d);
    }
    
    public String formatarHora(Date h) {
        SimpleDateFormat formato = new SimpleDateFormat("HH:mm");
        return formato.format(h);
    }
    
}
