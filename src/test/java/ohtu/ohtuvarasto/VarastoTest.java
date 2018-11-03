package ohtu.ohtuvarasto;

import org.junit.*;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto, varasto2, varasto3, virheellinenVarasto, virheellinenVarasto2;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
        varasto2 = new Varasto(10, 10);
        varasto3 = new Varasto(5, 10);
        virheellinenVarasto = new Varasto(-1);
        virheellinenVarasto2 = new Varasto(-1, -1);
    }

    @Test
    public void konstruktoriVirheellisetParametrit() {
        assertEquals(0, virheellinenVarasto.getTilavuus(), vertailuTarkkuus);
        assertEquals(0, virheellinenVarasto2.getTilavuus(), vertailuTarkkuus);
        assertEquals(0, virheellinenVarasto2.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void konstruktori() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
        assertEquals(10, varasto2.getTilavuus(), vertailuTarkkuus);
        assertEquals(10, varasto2.getSaldo(), vertailuTarkkuus);
        assertEquals(5, varasto3.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaaVarastoon() {
        varasto.lisaaVarastoon(1);
        assertEquals(1, varasto.getSaldo(), vertailuTarkkuus);
        varasto2.lisaaVarastoon(1);
        assertEquals(10, varasto2.getSaldo(), vertailuTarkkuus);
        varasto3.lisaaVarastoon(-1);
        assertEquals(5, varasto3.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void paljonkoMahtuu() {
        varasto.lisaaVarastoon(1);
        assertEquals(9, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void otaVarastosta() {
        assertEquals(0, varasto.otaVarastosta(-1), vertailuTarkkuus);
        varasto.lisaaVarastoon(8);
        assertEquals(2, varasto.otaVarastosta(2), vertailuTarkkuus);
        assertEquals(10, varasto2.otaVarastosta(15), vertailuTarkkuus);
        assertEquals(0, varasto2.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void testToString() {
        assertEquals("saldo = 0.0, vielä tilaa 10.0", varasto.toString());
    }

}