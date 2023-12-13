import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;


import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
public class ItemsTest {
    private Items item;

    @Before
    public void setup(){
        this.item = new Items("Item1","Ouiii");
    }
    @Test
    public void testItemNominal(){
        assertTrue(item.isValidItem());
    }
    @Test
    public void testItemNameVide(){
        item.setName("");
        assertFalse(item.isValidItem());
    }
    @Test
    public void testContentInf1000(){
        item.setContent("Dans un petit village au cœur de la campagne, la vie s'écoule paisiblement, rythmée par les saisons et les traditions ancestrales. Les rues pavées résonnent du tintement des cloches de l'église qui annoncent le début et la fin de chaque journée. Les habitants, simples et chaleureux, se connaissent tous et partagent un sentiment de communauté profondément enraciné.\n" +
                "\n" +
                "Les champs s'étendent à perte de vue, d'un vert éclatant au printemps et dorés sous le soleil estival. Les fermiers vaquent à leurs tâches quotidiennes, labourant la terre, semant les graines et récoltant les fruits du dur labeur. Les odeurs de foin frais, de terre humide et de fleurs sauvages emplissent l'air, créant une symphonie olfactive qui éveille les sens.\n" +
                "\n" +
                "Le marché hebdomadaire est un événement attendu avec impatience par tous. Les étals débordent de produits locaux, des légumes fraîchement cueillis aux fromages affinés en passant par le miel doré récolté dans les ruches disséminées dans les collines avoisinantes. Les commerçants, artisans de génération en génération, partagent avec fierté le fruit de leur travail, tissant ainsi des liens étroits avec leurs clients.\n" +
                "\n" +
                "Les ruelles du village serpentent entre les maisons aux façades de pierre, témoins du temps qui passe. Les rosiers grimpants ornent les portails, et les volets colorés se balancent doucement au gré du vent. Les habitants, toujours prêts à échanger quelques mots, se saluent d'un sourire chaleureux en passant, renforçant ainsi le tissu social qui unit la communauté.\n" +
                "\n" +
                "L'école du village, modestement installée dans un bâtiment ancien, résonne des rires des enfants qui apprennent, grandissent et tissent des amitiés qui dureront toute une vie. Les enseignants, dévoués à leur tâche, guident les élèves avec bienveillance, formant ainsi la prochaine génération destinée à perpétuer les traditions et les valeurs de la communauté.\n" +
                "\n" +
                "Les saisons changent, et avec elles, le village se transforme. L'été apporte les fêtes traditionnelles, avec des danses folkloriques, des festins partagés et des jeux qui rassemblent jeunes et moins jeunes. L'automne dévoile une palette de couleurs chaudes, tandis que l'hiver enveloppe le village d'un manteau de neige étincelant, créant une atmosphère féérique propice à la contemplation.\n" +
                "\n" +
                "Au fil des années, le village a su préserver son charme intemporel tout en s'adaptant aux évolutions du monde moderne. Les technologies se sont discrètement introduites, mais la solidarité et le respect des traditions demeurent des piliers fondamentaux de la vie quotidienne.\n" +
                "\n" +
                "Ainsi, dans ce coin paisible de la campagne, la vie continue son cours, rythmée par les saisons, les sourires partagés et le doux murmure des rivières qui traversent les collines environnantes. Un endroit où le temps semble s'écouler plus lentement, offrant aux habitants un refuge tranquille dans lequel ils peuvent trouver la paix et la beauté de la simplicité.");
        assertFalse(item.isValidItem());
    }
}
