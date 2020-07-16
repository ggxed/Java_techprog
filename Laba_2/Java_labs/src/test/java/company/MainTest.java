package company;

        import company.matrix.SparseMatrix;
        import company.matrix.SquareMatirx;
        import org.junit.jupiter.api.Test;

        import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void main() {
        SparseMatrix msp = new SparseMatrix(100, 100);
        SquareMatirx msq = new SquareMatirx(100);


        String resp = msp.product(msp.fulling_second_matrix()).toString();
        System.out.println(resp);
        String resq = msq.product(msq.fulling_second_matrix()).toString();
        System.out.println(resq);
        assertEquals( resq,resp);

    }
}