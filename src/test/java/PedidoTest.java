import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {

    @Test
    void devePagarPedidoComPix() {
        Pedido pedido = new Pedido();
        pedido.pagarComPix(100.0f);
        assertEquals(95.0f, pedido.getTotal(), 0.01f);
    }

    @Test
    void devePagarPedidoComDinheiro() {
        Pedido pedido = new Pedido();
        pedido.pagarComDinheiro(100.0f);
        assertEquals(90.0f, pedido.getTotal(), 0.01f);
    }

    @Test
    void devePagarPedidoComDebito() {
        Pedido pedido = new Pedido();
        pedido.pagarComDebito(100.0f);
        assertEquals(100.0f, pedido.getTotal(), 0.01f);
    }

    @Test
    void devePagarPedidoComCreditoAVista() {
        Pedido pedido = new Pedido();
        pedido.pagarComCredito(100.0f, 1);
        assertEquals(100.0f, pedido.getTotal(), 0.01f);
    }

    @Test
    void devePagarPedidoComCreditoParcelado() {
        Pedido pedido = new Pedido();
        pedido.pagarComCredito(100.0f, 3);
        assertEquals(106.0f, pedido.getTotal(), 0.01f);
    }

    @Test
    void naoDevePagarPedidoComCreditoSemParcelas() {
        try {
            Pedido pedido = new Pedido();
            pedido.pagarComCredito(100.0f, 0);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Número de parcelas inválido", e.getMessage());
        }
    }

}