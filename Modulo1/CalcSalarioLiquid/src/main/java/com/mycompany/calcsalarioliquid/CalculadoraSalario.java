package com.mycompany.calcsalarioliquid;

/**
 * @author Rayanne B. Lima
*/
public class CalculadoraSalario {
    
    private static final double SALARIO_MINIMO = 1039.00;
    
    public static void main(String[] args) {
        calcularSalarioLiquido(9000);
    }

    public static long calcularSalarioLiquido(double salarioBase) {
        if (salarioBase < SALARIO_MINIMO) {
            return 0;
	}
	double salarioBrutoMenosInss = calcularInss(salarioBase);
	double salarioLiquido = calcularIrrf(salarioBrutoMenosInss);
        System.out.println(Math.round(salarioLiquido));
	return Math.round(salarioLiquido);
    }
	
    private static double calcularInss(double salarioBase) {
        double valorDesconto = salarioBase * obterTaxaInss(salarioBase);
	return salarioBase - valorDesconto;
    }
    
    private static double obterTaxaInss(double salarioBase) {
	if (salarioBase <= 1500) {
            return 0.08;
	} else if (salarioBase > 1500 && salarioBase <= 4000) {
            return 0.09;
	} else {
            return 0.11;
	}
    }
    
    private static double calcularIrrf(double salarioBasePosInss) {
	double valorDesconto = salarioBasePosInss * cobterTaxaIrrf(salarioBasePosInss);
	return salarioBasePosInss - valorDesconto;
    }
    
    private static double cobterTaxaIrrf(double salarioInss) {
        if (salarioInss <= 3000) {
            return 0.00;
	} else if (salarioInss > 3000 && salarioInss <= 6000) {
            return 0.075;
	} else {
            return 0.15;
	}
    }

}

