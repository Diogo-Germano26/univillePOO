package Banco;

public class ContaBanco {
    public int numConta;
    protected String tipo;
    private String dono;
    private float saldo;
    private boolean status;
}

public void abrirConta(String t){
    this.setTipo(t);
    this.setStatus(true);
    if (t == "cc"){
        this.setSaldo(50);
    }else if (t == "cp"){
        this.setSaldo(150);
    }
    System.out.println("Conta aberta com sucesso. ");
}

public void fecharConta(){
    if (this.getSaldo() > 0){
        System.out.println("Conta não pode ser fechada pois ainda tem dinheiro. ");
    }else if (this.getSaldo() < 0){
        System.out.println("Conta em debito. ");
    }else {
        this.setStatus(false);
    System.out.println("Conta fechada com sucesso. ");
    }
}

public void depositar(){
//    if (this.getStatus()){
//        this.setSaldo(getSaldo() + v);
//    }else
//        System.out.println("Impossivel depositar. ");
}

public void sacar(){
//    if(status = true){
//        if(saldo > v);
//        saldo = saldo - v;
//    }else{
//        System.out.println("Saldo insuficiente");
//    }else("Impossivel sacar")
}

public void pagarMensal(){
//    var v float;
//    if (tipo = "cc"){
//        v = 12;
//    }elif (tipo = "cp"){
//        v = 50;
//    }
//    if (status = true){
//        if (saldo > v){
//            saldo = saldo - v;
//        }else{
//            System.out.println("Saldo insuficiente. ");
//        }
//    }else {
//        System.out.println("Impossivel pagar. ");
//    }
}

public void ContaBanco() {
    this.saldo = 0;
    this.status = false;
}

public int getNumConta(){
    return numConta;
}

public void setNumConta(int numConta){
    this.numConta = numConta;
}

public String getTipo(){
    return tipo;
}

public void setTipo (String tipo){
    this.tipo = tipo;
}

public String getDono(){
    return dono;
}

public void setDono(String dono){
    this.dono = dono;
}

public float getSaldo(){
    return saldo;
}

public void setSaldo(flot saldo){
    this.saldo = saldo;
}

public boolean getStatus(){
    return status;
}

public void setStatus(boolean status){
    this.status = status;
}