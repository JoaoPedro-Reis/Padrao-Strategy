public class Pedido {

    private float total;

    public float getTotal() {
        return total;
    }

    public void pagarComPix(float valor) {
        CalculadoraPagamento calc = new CalculadoraPagamento(valor, 1);
        this.total = calc.calcular(new PagamentoPix());
    }

    public void pagarComDinheiro(float valor) {
        CalculadoraPagamento calc = new CalculadoraPagamento(valor, 1);
        this.total = calc.calcular(new PagamentoDinheiro());
    }

    public void pagarComDebito(float valor) {
        CalculadoraPagamento calc = new CalculadoraPagamento(valor, 1);
        this.total = calc.calcular(new PagamentoDebito());
    }

    public void pagarComCredito(float valor, int parcelas) {
        CalculadoraPagamento calc = new CalculadoraPagamento(valor, parcelas);
        this.total = calc.calcular(new PagamentoCredito());
    }
}