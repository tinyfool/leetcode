package p0336;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution;
    Comparator comparator;
    @BeforeEach
    void setUp() {
        solution = new Solution();

        comparator = new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.get(0).compareTo(o2.get(0));
            }
        };
    }

    @Test
    void test1() {
        List<List<Integer>> ret = solution.palindromePairs(new String[]{"abcd","dcba","lls","s","sssll"});
        assertEquals(4,ret.size());


        ArrayList<ArrayList<Integer>> expected = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list;
        list = new ArrayList<Integer>();
        list.add(0);
        list.add(1);
        expected.add(list);
        list = new ArrayList<Integer>();
        list.add(1);
        list.add(0);
        expected.add(list);
        list = new ArrayList<Integer>();
        list.add(3);
        list.add(2);
        expected.add(list);
        list = new ArrayList<Integer>();
        list.add(2);
        list.add(4);
        expected.add(list);

        Collections.sort(expected, comparator);
        Collections.sort(ret,comparator );

        assertEquals(expected,ret);

    }

    @Test
    void test2() {
        List<List<Integer>> ret = solution.palindromePairs(new String[]{"bat","tab","cat"});

        assertEquals(2,ret.size());

        ArrayList<ArrayList<Integer>> expected = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list;
        list = new ArrayList<Integer>();
        list.add(0);
        list.add(1);
        expected.add(list);
        list = new ArrayList<Integer>();
        list.add(1);
        list.add(0);
        expected.add(list);

        Collections.sort(expected, comparator);
        Collections.sort(ret,comparator );

        assertEquals(expected,ret);
    }

    @Test
    void test3() {
        List<List<Integer>> ret = solution.palindromePairs(new String[]{"eihhje","iaicac","hjfce","igbfbbebhbd","ad","bibhiibbe","bacfjiegaiibifhdjfa","bige","hhahbhjcfa","fd","bbbjdf","idfgbbicfdaji","ahi","djbcibbbjihi","iibcdebc","ijcccgdahhebci","jcbjiebefjef","gfaiahcegghbgjjhadf","hdhbjfdiddcjgejd","digfecfdgdhjf","beffabe","aaefeh","ih","bigdb","ihjeja","jebiaibeegjdcfe","cecjhghchfedajccf","hejfcdajiddacg","bjbhaabbidfabe","fhiaddiihgfcfjhaijb","cifg","gh","idf","hhabbcgehc","iagiighiegcfdibhb","ighagffcchabchjcjdi","hg","bchabcgjgdecdbbcd","cc","hibihid","efheeddi","effefgih","gidcahijjgcfchd","aaaehigebeiifahaih","daccjgajbbfhdjfcdja","aaehajdbehdggcaje","fafgbffi","eehg","iababficcfgg","aidajfegghidgie","bbbgddjbdg","gahde","bjgecf","ebbdihdbii","fcgjjaaiedijhbdjgebb","fcahabeghabedd","cechjeda","igcddjbhaibfdhbcfdj","eaj","jbhdigcfagbffibeib","ijedbahdbbibjh","gdf","iicefeg","idjceaegiefdfj","ahbahiccagicjgefaif","je","fid","jbjaeeghgh","egdajeja","jajfaadf","fcicdhigajiiffifb","ibgidhcabeiahfjb","dgijjfidc","bacaagf","ehdeiaihhag","dfedajcaahhjccj","fe","hedefdcideajbfa","edaaji","echaadjhaf","ejeicehcdbf","hbhaiagfibf","idefehdagh","eegajhgdgdajhbeehfih","aiggccddjhgibgifafda","dgacbidggcega","dffjc","fcacbddihjhddcddchic","gfhhhiaeaj","gahefhejfafbeg","dbjcjfecbefiddig","hc","cabfighdf","hahfeaiggfh","fffcf","edhdjgcefiigic","ihajbbgcfdeeigeief","gb","hcgjahd","ae","cifbbjiijjighjggeih","aabb","hcibebebihbigccibfd","hha","figija","jchhb","gfcdbij","gaefce","c","iaeeidacdgecbeigfddj","e","dceeicjgdef","gdedjebheiigbgeabig","hcbffcieieaa","ahabegeea","ebedigbgacjdhccae","ihibggcgddcgfabdfgc","ihefhaci","gibfcdfaejdbje","idfga","jfdideiebdghighhig","hj","agdcehci","d","begfhfjdfjiejcdc","hiiifgbic","hdffad","eggabhjjgiaffa","beie","jdcejcegfaffb","dbeaghihicdhhch","ijacdjehjace","iceabjdebdhihage","gjidf","cacc","ijjcahehgficehii","jdcahh","cefbccb","gehdefadigcbhjc","eifbhdf","gffcddaaagc","dcgh","dgjibh","cgbej","hieggchibcgd","ca","aaahhacigdijhfbcge","aieiacbbdigecjdeg","fgehighad","beeifcbcc","eej","eidcjf","cegj","aadgadg","ejjbfaca","ifjjb","iidcfffcfgi","ajjgdidcdbhdhdaa","ibjb","jaecgebbgdddai","bhdhgjgghfhhjji","begihba","dgghaga","ccjbfbjaeeijdjbhejh","cbehafbhab","cidafi","hbieghhihg","bdcgiacajgggeh","fjiadbjjhciaef","j","edggacbbfejebegjf","bbjfa","dijjebabfghfbb","bbcedcj","aehjcdja","cddhbgagfiieb","hejcehbjbgccbbd","cgbhcdahff","agjfj","diicicgbeafb","aeeedjjjdjchdgfahe","eajifceddbgfjifhcjed","bdfecciadadaief","hdj","cecibcdfhdacef","dbagafghaahjhfcjd","ejhcaei","jhcgbacbaddigjc","hjjecdifidhijbjighgb","hjjacdg","dfi","fbihiacihh","bghh","efgcd","jfcjgaiebdjjcffa","ihechjdghbj","eaafieehbbfjff","gdccieebfbgbag","becjfdccjbcbebiichch","becbachhbhahdieb","fdcafjjedda","icjjbif","efj","fheadj","dbcbjecaj","jjeffdhch","fbfdcdh","aajfeefhghhjhbga","dhhabdidcjbfhgfcdajf","efhh","ibj","dehiffcciaajd","jjfaaggebieejcfd","cfhagj","figabbieajcjiaiefj","djigagagbg","bcihbjjbbajhfbdic","bfdai","cjggjdffjbh","dfdgedacdhcg","ibiheccaefiefcch","jihd","jaec","bfbfjadchjjgiigcech","edfegfijcgdfhacjcd","ffba","hhciihajgebbbj","aihgcghcggbjbia","djjccdiffich","hddgbhagaafg","jae","cbaceaaedghceachg","hjjfa","hcgjafjcaihdicgajjh","ahgiebggjaf","daejeecaieceeci","jghdgfgfd","h","jahafifjdg","f","ifi","fifjiacjhdajjgej","bidd","edefbfic","acdecgjahgfcc","ij","dfedddejafeiggideib","dgj","ageaddjh","cbgceei","cigigiadhcgbbga","hbecjhb","acdhdeg","ijcceidjfjgiiid","fgfbiejfbdjjabjcabdj","gfcgdajj","hieijg","jfjabdeeaidfa","ejdchhbdeegiijajij","fdgjejjifedfbdfjid","adgfjicf","bggidghhbdjijghj","aacjghdfbeefgdhfbc","jffehjgcea","ciebh","ig","efifhjgbd","bdj","jbc","geehbhfdebf","degg","edaccj","dcidaeghihcddjiih","cja","egfjcgfgbcj","hfigfcb","gbedjddd","abbfbgahcajd","jedid","cacccejg","gejfjbfecjfba","aajfegh","iijibjifdgh","fbedighjfc","icjfjdhbabdcjh","gcejigfjhjfcjbiejc","i","ajjaigegcjfecejdahd","cij","ifaf","iajahaif","dhhgfaajfeig","egjhhggeeafjhjaiab","bjeh","ji","jgibdhjgieaeieefhcb","caibfa","aibi","iejdijbhej","efbdaehfdife","bebafghaaahigfc","eehjheh","jhibcgifc","bfibdhhibdhb","djdfeiegdecjcgcj","bagcedbaeaigb","gafjcag","gfeg","jeegbhbadhidbjica","fgbadbghhggeachih","gdbafiid","bcjdj","dbehadhghgfjidjdi","ifhefaedcjdac","hcgaga","b","fighadfjdfibfhgj","eifcjff","cjjfjcfhjjgebgeadchf","hdjecaefejiediea","eecjgbe","acidfcffaigbhihg","fjijafhbccahbijgjcg","eacbeigecdjb","ejaifghjbhcgaa","bcgfebjhiccegidg","habejifajb","hceaab","fjgidbj","hjigejf","jgehhci","eacfjcfjgdfiabgd","fbeicffedaeijifdhg","hifjacdhfchigcafcafb","cbh","bagejhibjaibajihffa","gddfecffdhabdbiab","ijbahagjcgj","bebjccbb","cggfhefibfafgaibdb","fbceacf","ccdbfbcdadbfbcfbd","a","fbhdbfei","eachgdec","ffbg","hcijfeafjhfdhee","chcefbjffbbeigh","aiga","cajbajjacddjegh","iejbidachf","fihfffhhch","dabagbbffdgbccfjbfed","jbfcjgighb","idbdfbibejebbbfchjb","bfdbjjjbadcgiahhieb","daefijicifagdffjdhb","daaicdgjaahacchj","egbddhefjhjcjgb","icdgegjcch","fffgejehebhd","ecig","haigjcccibejiebc","aafiahiaif","ecffghijaedhfji","fghbjibahcaejggh","cfa","gaichcddeaddbb","hgb","hiba","jjfejcfcgda","ihedbeihcbjfgi","ieicgehjhaefcg","dhbehfcijdid","fdeehiigbcgebejae","cjha","bhddajdcahbhdgefiic","jhbbcgcddijdfdgigeg","ejibhbabicdfeagcja","hbfga","hgfg","aigjjfabdgjj","gahjgafcdhgahf","eacbfhihhifb","jedjiijgiegabhgb","jbi","bi","bahagj","chjeigchhicjfhafj","ifiiehjfgjahfjigg","bcfcccibeefegfd","hfbbajbacfhcfhbfbiij","dejhf","jfiffjjddebc","aiadiighcch","jecjjagdicgfad","habgcc","jhbfihd","hidhbcibdbcjehadddi","bcbcgcgjfaaahhaadee","bcadddeh","ghjbjhjaedjgihj","eegciihejhghaeejjfcg","ddcigjfiicieedhahhjb","ffgdjgbhhdgjg","iihcijbbdedif","idbhbeicbafcbh","cdhdaadbhieigfbbhhi","fcigcia","ggjjbbggcacb","aceciiige","haeb","eaahfe","didjebhfbd","aeaagghed","ggjhe","fiacfacjfdggi","hfdahb","jfh","gdiigfbifjdbeijjhjci","cbhadedj","fdfccjaadehfddfhcihb","ahdiddbddifibejjiege","ebcgh","fgaffihebeaghecag","feidjefefcffiigchf","ibhbeedi","adbiffhddcdgfffagid","hjhfhbia","gegadcacciiefhbdacj","idjchf","agchhjbhjcia","idafgegahjiahcjbde","cfiibcjcechcje","eebgdjeifeej","bijfhedbhi","ag","g","iggggdejbdcibca","cdjeaeaahcha","dhgjjdcciai","hdjadbicjbgeddfgf","fjbcbjbeghcda","aegbjdiifa","fceaffjjihijebj","aigcifcfjfgheiafic","ecciaijcehcc","cahibcihifbhdideidf","idjdegg","cbgeicba","ihe","jc","jifdhga","jdjiedfggbidfibgea","dd","fafeajbeafhcdfhd","aabgbgaceeabdbiad","ighaeihihfjdcjcbj","jifgjdcaheeaghfigc","acedddibbcahfdh","fjahiajjeiicfcagcjce","eheg","idbificjffejiccbdh","hdhc","hjcibacg","eb","iacie","jbeiegaecffijig","eafgj","djgieedgfgadfjfajfic","gdhjfaidb","cedbgaicbgjjg","ah","ifjajeaggich","jgfgafaheebg","cjjhd","cfebhbigcidfaaghdh","fdc","ieig","abb"});

        assertEquals(83,ret.size());

//        ArrayList<ArrayList<Integer>> expected = new ArrayList<ArrayList<Integer>>();
//        ArrayList<Integer> list;
//        list = new ArrayList<Integer>();
//        list.add(0);
//        list.add(1);
//        expected.add(list);
//        list = new ArrayList<Integer>();
//        list.add(1);
//        list.add(0);
//        expected.add(list);
//
//        Collections.sort(expected, comparator);
//        Collections.sort(ret,comparator );
//
//        assertEquals(expected,ret);
    }

    @Test
    void test4() {
        List<List<Integer>> ret = solution.palindromePairs(new String[]{"a",""});

        assertEquals(2,ret.size());

    }

    @Test
    void test5() {
        List<List<Integer>> ret = solution.palindromePairs(new String[]{"a","abc","aba",""});
        assertEquals(4,ret.size());
    }

    @Test
    void test6() {
        List<List<Integer>> ret = solution.palindromePairs(new String[]{"hdhbaggbjiagiihgidda","jj","ihdebgbhejebgehebda","fddhieigcggecjcjefga","eeabdhhchghj","hedeeggihjcddghhb","hjdihahibjbi","di","dafabiedacdafhd","dehjafibiab","hjdgjcjefibgjcejgfif","f","ebdh","gffgffgaahfibjajjai","ejfdejhggcbjegeccfaa","gdfbhcfi","gfejjbjiddjdgjaj","hedjecihdhhcgcgbcjd","jcgadfaj","adcbfjej","fiec","gbcgbgfdheb","bgcdi","dejfcjbbgh","d","gahfa","fhjiaeiadcchfjdfefci","afjcfhfeg","dighaidhgjjjefag","ccbia","ghbcdbcfgcjjjhbh","hiecjhgijb","idgbcgihc","ajcgieggcdfacjj","fddf","jcgihdgbgehjhga","feaeiddcgcigh","iffabaaafacjc","hbdgeiffcgjecfibec","bfcjdeicdjeadaadia","c","ifbgbddaaigabdhggg","gdcjeheigh","aeddjj","cihjhagbfbijgehcbiae","he","bedbbfejhdjjgb","hacggdbcbac","ggbhjibc","efjhgfdgciichb","ebejcbdagfcihbaecjba","idchei","gahibd","dhhighidddefe","feiedgaejdahi","ichbcbehfjcdch","hiebaie","ahj","hbijd","dideedcdgjeaidjeheji","eaehibaj","ec","da","iiffe","jehjcjajaabbga","hcjacedfddbc","gc","feibcdejchdjggb","fahcifbf","ghiccfcaaegjcbge","jfed","cdgfbbfbcg","iiffeidgiji","bfdfefhejbhdj","iijdjidhiibf","fjhigfdijbedbibgjh","hbid","iafd","fehfg","bffahbfcb","ddbhbhfe","edebciih","ejhehahghec","cbgdggcbe","chihjhbbbgc","eighcidiiaacff","gheb","jffffcebc","cbaidfhfachifhhebdc","cjhgaibbe","jgadieed","gbjigdbbfcjgjgcid","gbbjijhhhcgeg","cbegc","cbjcehjhjd","bjgaacja","cc","cfg","debbddhbejjc","dfiabccdcgabaehcbij","jhj","djdjihejhcdbd","jbcbijcjhaggf","cdhghj","fbfdgcffdfidadj","ejgicfjidbibeeb","fieadaggdfad","hgjceffcfifhaifa","aedhiic","ehfi","bciibegeedfhjhegcf","ahfijag","cjeaicfhjbbecici","ibigfeabacagi","bhidhiichcc","haaafceh","ee","edgeabaehgig","haijagdh","gcdabchaceiijjggeba","jeidbgdgddjjjdecf","jebbbjfhecdefdh","dggfadacjeghabcfda","ejjbbdgjh","ficfaajbcjg","dg","abjchgjie","ddjgbjihdbhhjg","gdhhb","bigghigaiidfhijcbha","addaegbagffcd","jaggabgdhfehffb","jhgdjiacegbebbhabgj","acacadjcee","cicjjeahajcjba","hedbiidifbfji","jegacjccebijb","acc","bicgfdbbei","gjbacjjhfc","agde","hefhdgafbiijc","ifidbahcfibbhicifde","ahgecfjdegaji","dh","jehefhdajbib","i","dgcafiacbefhafdddh","ddf","gafiijhgfhicfjcgjbe","fbggdhidjihbddjef","bcacddbcadggjeccjbb","igajgeggjdba","bbcfbbbdccdfaiibacf","eccfigfd","cdcjigich","abjfcfdfedae","ah","hggafcfhf","e","giaafgddcecahcebffj","dcdejidfbcdbjcc","jdjfdcaeeddffjedga","jhdehdhbdjdad","aechhcdjfg","ibifbdcbbaebdgd","fdfhiaajccaafaaaa","ifjah","hgcefhijjidbcad","caicgiijbjicbhbdcbd","cgcjijhafcbf","efjedigabfej","hegabbfd","bbghbghhdidccadicb","ccieeheg","dbacaciciaia","hjjehjfihhbbiaaf","ceh","ejj","ceaifiddjcfcfgi","geja","diadcadfgje","dihjdjiadcebb","bhe","aefddjbdihia","j","jbegdb","cegbiajhcefcdghj","gjaggcggfad","fcbfa","dfjfjieg","gdfgefheiacee","dfhhfehcjddbhdb","ccehihj","ea","aighfdfhhabjh","dfch","cbahdjgbciigdhi","bdbfceahjc","gj","dhhghgeb","eigachdgdg","fihe","dfjcedadbebidcbh","ddbeeeaf","ai","jiagfbijgdjja","ajjjgbfbcgc","aciiijaajcbf","gjbefcbgijbibjaac","cfjceibacdafhaieebae","bjabfeecbedd","hih","eaaejeeghfaeffg","ffhebgbggj","idhffih","jjjaccgdceiahacii","ddgdhjdbeahdaieefa","ghfhgccaadi","cbehdihh","cdeghijecfaajhcdcci","dibfdbabeeegg","igbahgaefaeajgfe","cchdgaj","iiefb","cifdihdijhhagjjce","ehdchh","adfhcfjfbaeb","dhdidgffbejch","eaaehdabjigd","geaccgbcihhfdidhf","ahdbhfbibhccii","addcaah","gihiiaie","aaiihaac","bchbcihigai","cdhjhbaccidcfgaadjif","ieibcf","ehdeeahjjgj","gb","if","bhaiejjffggbida","fajefdhiaaec","fcjcffjd","dbchefhjii","baeiafjgdehaeafbh","iijcgabgjc","cgcggajbbaeiac","gdahfdihifdbidgfhgf","dfehdbgdf","acadjgceghej","bihbhc","behihifdi","iaifdbiiebj","gdigad","bcbgagaifiejggfff","jjafaffebeida","ccbdaagdfh","aghibjgbbfe","gcjgaidadbdgaba","beahaaifcadfiafciecc","jiadiiajiicfjad","ahg","hijgcbjjcgjebge","dgddahbjdbafjefgifei","dajicahia","ffeifh","bgcgcabibhdjgdfda","gdjgie","jdjhhf","jdhabgifidjfbhagijff","adiac","ceedhbec","ef","dhdcgjgehcjeibfbjgd","fhjhaffbachd","dehfiaficbgdb","gabbehaeafc","fjbhhhbfbgfagaafh","h","jicabbheahfahjice","dec","dbchh","gah","iahfgjgaae","hiec","bgjjgdjfcfbidfdcfedj","bhjbjjdjcjghacicjdha","bheadcgfcjjfaefdighg","adebfajbaajbjibjdf","fghbafa","fcgciiidgaejfhddae","ifgajgijgcheefdfecai","jadfg","ihhiigbied","ejaajbcfjifaahhdbeh","dhdjcifhgidfgbddg","bifhfffjfhffdgfc","eg","fcjida","cgjbjeb","jcffhdaaecgiej","ehgehia","eddfiiied","ijbabagbbdhgdiagacbh","gjejfeci","jbcegdigafcbcajhe","cifgcbjfeaajdj","bbcaifeihhai","fbdbfbfegijjca","ifgeaegejjhchagf","bajegjjbiga","ghcccjcgdijfgdg","jdgjjdeehjhddd","cjbigd","bjdi","hiejf","bjfihieehj","jiecbehjbijaeibaihc","a","djb","dicecbifcicabgdcdag","affccaccgjbaffa","cjfbchejebjddbbdb","fjijfh","add","dbja","gcbjcgedibbhfi","ggdahfejagjbc","cjfcidfehjghg","aiiiajadcggfhgebccej","cdfjbe","dee","dafdcjaifee","abbjcheigdghiddfja","ifbha","aei","bhhahheeajhifcaijc","gaiidgcfijid","aagbhgcgechgaddbc","afiaiejfchhb","aciaadijfagaa","ihfe","eggcjiiabe","hjacbfjb","igggcgdbjaeihjfc","eiaehgjffjfj","agffa","ijbfjddedhhbcf","ccijhhafd","eabifhcafbbij","cgei","hffebjhhjfeafcdh","fhiiaffhfbe","dcbigc","hfadegfaai","aa","ggaibddbehe","ifa","hfcfcidiafdejfehad","befbfea","fa","jhfeadiffchia","cegfaigfcjhiie","hcc","ibhabeijie","jdchabdgbhhdiej","jbhhdfeahbedea","bbgfeidbjibfihddjdbj","eb","ahfbbag","ddhgbbegfjbdhfgifac","ejc","dgdafhbajegdfff","iehfjigaihc","giheghdgebffied","fhj","agcbhd","hcehigehgcggggb","hbaggfdeejfjebe","bfhdffgd","hf","edcjic","jhcg","dhbg","fiabgdcfdgadbcebgaag","hgcjhhiahijeichaeb","dj","ehfic","edajgfiaahfef","hdagfb","diecgcjdjchhd","agdfdicecdchjjifdfg","ifejadagaj","ccdaed","jdgbhijed","defbdddgijfffbcbae","bbecfbc","fchjhcedjbjjjchehjhg","agfhccgchffghdi","fgjjidfgjdg","gfjcbagigfdgddjhcf","babehhihcdhcfeajdch","fhggdccfg","hfafhjbehabjfddbj","eccfj","fjbdhgbcfjjbhegbbgbc","defgeijgacbdigi","bjajhehi","fdahjdcedajgfgjdaiai","hfh","bhffedgfigcaacjfeh","dhcdajfcgiechjc","ghacadjgaeecdccjjgc","cbhccbhfdgfh","ceacfgggebhjfa","ejhhi","fbffdc","gejdhdjdajdabdidjjjd","idffja","gdagd","bjgbfaad","gebdeibichiga","iefbdeaeeeagjfedab","ehbahhbd","gcg","ccafeifdji","cjfdhffcbiagigg","bi","geedcccd","eeebfhjbjcbdb","gebicd","iib","gijf","hedjj","aiajggchjh","cdahfcfcfb","defj","hihabhc","hachfabdbgfci","ejcecfced","ffeeifaiedcjffab","gfibgfegd","djfhcgafdddahg","dbddfbbedghcgb","hiecfjbdeb","ddcdfeahgcacegd","jd","hbihhhcdafgeeeh","gcbbgf","cghfgdcg","efhgbefdcagdfhi","jgahjfhfbbg","hjgdebfdfajb","icggjahgjaaiihbibg","hiheaf","jbeachabddj","iafgejhahhjejg","gfjb","hdgachcbbadjgcdgacge","hejjihigaadagajhag","dhh","ghcd","fgadjjigfiiafhd","ieeffhgichbgaa","bcaibhi","ehiheh","dbgiiehdjigadfaficg","afgabgdffch","ijgeaaiajchcbagid","hif","hgfjjbifcefjdagada","ajdjficegcb","hiij","feh","deec","bcjcecd","habbegd","dahfeeajiafcccgbcadj","dcaedg","edcaejj","hbegdcfcfhicihfi","fag","cabiegcbeigaj","ebhegggcggijbhehga","dfda","ehdcjecedij","bhbfcede","agg","jibbjcadihhcija","bebcfbjfgcaciccfgb","eafecf","djcgc","ehf","ibiggadjieia","iigjdda","hgjceajhebigjfcbcc","bjicijidjcgjdjdfc","hdi","dccgbhajjchb","eadgaahiifg","ffffabigiifigghcggea","bgdaefiahjcihai","jfcfccbaiihcebdgb","cgffigeddgejac","cdjffbffheijdi","gjdgbaacbdbd","ajaeaiceejjbfhfb","jcjeeade","ieafjffagacdcacadi","geeab","ahhefiabc","egajjgjcfcjh","b","cdhedbfbciicbdj","bhafcige","gfcijgdihjce","ghhgbejgejgghbhjebj","jfiaiiafdda","beciabaifhfjgaaghjjh","fbgccdie","eadigbeh","adfaedgaehdaifg","jegbgbaf","gafag","jghajhdbjd","cdedd","ihh","cchjfhhfcahffca","caea","bgdgcejgcdaeicie","efbgihdghjh","ggcaghhe","cggc","ebjihibhbbfjd","afeechgej","dgeidej","fcfjhjc","jdcfgeihabjebi","g","ifg","dehbe","idjaaeibg","hiecgdiiefggfibcddgh","jcaeccbbjdcd","aegbbijaebfc","fdjjc","eggeifjahhdbghgaca","gegaiadicebfcfdj","dbjbhfhgefjgaihbiedf","hbgheibafbhhe","bcjdieidijibjeiae","bjj","bbibhh","addefejeh","feede","edij","fjaacehcbccdgccef","hajhggagbffigbe","fjcj","afddfdciefjifihbdgia","aedhieaiadifdahfc","eadigbdi","afdj","cgbchibiaijif","cjhf","cddjgcajcjdadfd","bbheggdidg","cbgbcjgfjhfgjdeicca","dgibdjbacaefdhggbhfj","acjjgffcfhedifaagc","icaaffdgfcfdieghdbih","bcjfh","cbfhh","hhgjib","icbcjj","efjggdeddhhg","hgjabedfedg","jhibhcbah","ieafgiecaheiifegdic","edcdheghaidd","igje","haihhjjbagede","haehddhdaig","gddadbefij","dcjdb","eea","ic","fjefjdgcagiiabdifb","gfgfg","ceacjehccacgcbfghe","dibbhd","bjcdj","iia","hgbgjcijb","ihf","jhhfffegihfacehai","cffgjaa","ceeebhacacbiiijcfejc","ddefcgadghf","jeaadficdg","fjefacceddhiaehg","hbjc","jaifabhifaefdjafd","faiacagccjegbff","hfehf","igdce","cgff","gjfjfiaiaffbe","aijajdffiiijchehi","fjii","iajbiia","hgiibjaeijfg","jaabiacbfigcjiij","gce","igaac","cjcbhiaehccd","hdadfegeccahcgjba","ggigfhidi","fgebd","gjhbdegiihbddc","jhgheicejjc","egbagabbcifi","cgegg","gbbdeghahdid","bffdgchjadi","dfcgdbifidjjagaj","behffbehhcfjeiehied","gbadbceedcbjcfg","djajhffhifjdhjaieij","edheja","jggejigihifehjfah","adhfffdjadciidghejdg","hihbcgjechagebfjfdje","idedg","dbehgeidgd","jabjf","hdedejcfgiebeebc","bdbajdhdhb","bbbgbhbifabgbijgg","gaaehhhdi","jbjieciababffjageibc","eaeaijehdbfaaddcad","fbda","dfifa","idiajbjiadda","cfchdedeffhfjdaig","cgcbgcheaehehaajeib","cccbhidfjfje","jfabh","haeabffgeghefbd","dibcjh","eiigbfjj","bbihibbhhbjcfcb","cj","dd","hiidebfe","jacefbffjgcccfhebab","ifbjagjeggca","eihj","hjdhjbi","gajd","igehaabddcihjgb","jjgibbd","cafbgeajbdiggg","bcfidjahdcbe","cjffbcibedidbhagghj","deijcajhjdc","cja","hjcagajajcjejj","fad","ceehfeaceif","eihdggijfhjba","bc","eejehjacjafjgij","eabe","ji","ciieeiaahbijdc","ajghiecehgcagf","gdcfedgfeaccjhefi","hcfiaagfjbgfej","feaehdbebhfagehgcfeg","edffhifj","jicej","ijcaijidjceddfdef","ejjaaaiffgbfdgagj","faajf","abigihddcfgjh","ggbfcajgcbjee","bhchjchadjdfjchaiedf","diibaahgfgf","jbdhgchbhfjgah","ijehfgdgggeabcff","ebjjd","acbebeeb","hgcbjicbfdfdaidaacbb","eedfdahajhecbbfdjaae","hhgbghifdieajfehhc","bibda","cgggh","gdbjicagbhafeeghiif","ffiddebjehhifhcbc","habbcdjgdbaiiffjjcic","ddjeehadbgcecahbibh","eiajfhdiafbfhfdifi","ihj","iaedfhijegeiif","gbgccgifggfahfcjdghh","bhh","agjhh","gidcfhfcghgdc","ebdjdgcia","beiggfebghedi","iibafbbj","jcfhjedejfcbchieghf","hdddcdajgfbca","dadfjiiaeeddgjdicbf","dfhbjcgfdeeei","bjbgeeddibgdgig","jjfjehihhj","igbfieicd","hh","cejjbbeg","ijibibifd","ggigbcdeabdiajfibi","ebjdacaihcbbijeadf","djhcjbabdbb","jf","hehchfbcf","cjghfadce","hdfaaiciecbh","dhdchfadebgcccd","acfbjdeffbfhdif","cdcbjhja","ffgbfdejdcecfjfii","aijgbhfchhihgejebige","idgjjfdcehhaddjha","caaigdciafihf","cg","eibijeiibheacejha","feji","fidbidbjjdbdgfid","jbc","hbcjgiedcbjbcbefd","ii","fah","eejcjdbfaefh","hbjeeh","jgigdbgafc","ihjc","dfdaacjjacgciijhcib","ahibbfabidegghefjhg","egigbijh","ahe","bahdieehageejbde","gjgbjejaefdgabgfgahj","ibeahdjhgjhcfejjejib","cb","ihaiiafjgbafgigf","eagj","fib","cedfbdadfiaja","fbdceeca","daf","cjb","hcfbeceidjfdie","ifbi","fdijgifedhcaicjgc","fjcjgfh","iegbfibgfbjfjd","fgaheegcicdab","affcddihfidhb","dibbcb","jhcjehdfjebgbjic","dfd","gfjhhfga","hcifaga","bgaaacaig","iidichgadjijhdbc","edf","jhedg","ebbighfadifg","hgcgffdffedijhhbb","bdehgc","cedeidac","cjbhcihfjfgebf","hgjhhccjecbcbddfgcj","gjibabjddfbjcb","ebhciahde","fcdbfihbaehabjjhi","dgahfaeac","jfhjihagf","jeaeciiagbcjbhhii","jcjieejghfehcf","accheh","ggicdgcgjga","ifeafcdhefdd","ddcdjaeaffe","gacejfadbiibiiifjf","bbhbaheceifjhagbid","fieifeag","cbbicba","daehh","bgbbdaijjfc","bgic","jbicbiibagd","diifadbg","bdgcjagjeb","jghiebchaheh","hgiccb","fafccfagjadjdhhifb","cfdhidgehdgbeacdeeg","cidadhhbhfaiefhhdhj","ihb","ggfehbe","bfaddecjahabcijf","cjbfbgiabf","cebcj","cbgbaaf","gaejcajdgjjigiaabahi","eifeihieheegajicch","ghejcbcjciejcbhiahf","diaddacacggbcf","idhdejgdiajef","jgeejihaeajh","agidcdfdjbgfceecegih","acfiifbfgaifhdbebdig","ihajjgdbajciafbibjij","jjcjachecfa","aefffdgdjchbejbagcj","agdabcachieaih","bddhbgjhge","efaccbjjjgdejfbdbah","feddeghjehag","eehcahgcdedefia","hgddfihgdgidc","iegdai","djjgiehbdjhee","fjaihcjfihgeia","cicjdgcfafcehgbb","eaefeaddae","hchcb","cghjfiaigeabb","beghdhiaiadeacdfbiij","ddjgiaeahec","aadjajga","hjdda","ieibjejfbfcfi","ghhejfi","hjifjjbdcjhajbdgjejh","fjgegdcjciaeiaajih","cahdafdghadfehgfjdh","bgabfgjigbaej","idgfedeebfdebd","hagiccacbegg","fbbhahbb","bge","ijihdgfjhajhfegce","dafdggjbgec","cjafhcbfdgcjje","fbhafe","jbfccb","fei","cbhibjjfajj","geidcb","hjihijjfgeih","hfigjgbbggcc","dfchegbbfiebifdd","gjadjff","ebihefeaaijbfbejec","deaggfaje","idfeaj","jiahgidcfaicjgbjbhbb","idgbhicdjgcgdbeg","dagfja","dbhjeeffhjd","eebeibf","ghedgabaeabd","jcigefjdchidehbg","ifdghchbfcaiegfbieid","hdhififeddghjgghahjj","icgdbdieghhddjibgeb","hcjggbaiiagjfjafeb","jgiiefihccicbd","icbiabheh","gd","jecgdegiabjbebaedhda","edachaahdjb","dgagjggh","djdbhdhfhfgfh","jhaibiiadjbdjfhe","dechchfbghefcdbcjg","dieghajfijicaaheejhd","dfig","gbeifiejajejhjbc","ehhefchfcbac","iehifeeghfcjdbh","cdfj","bihjacaeahbfagib","baeeaehggbhajhejcb","dcdahjed","dhaeabfjhdfcfcbace","ajeahjhiiaiiaibhbi","gaiiiedgefb","hafhegeabecfaga","eehhjjbii","dbdc","dijafhijfeghfcegcjh","ecbeejjiibcjea","eibiiehijibaadjae","dahbccaj","hchhfjjcifjfadgha","cdfbccheaggfdiigbag","ciheegdcagfacgeia","fahj","ccbeg","bbcjjjd","ddgcahffi","bieiaafgdiebjcd","jiffe","jdbcagg","hciebdfahigbf","cd","jcfbjieeahagg","ffaejijcjbfaf","efeaaddgfcbj","hdjehbijgedfej","fb","iefjdcbjd","fche","jaijd","jfbgi","bcddfgfgdgige","igcahjdaef","jedefeahcaahb","aijchgehfih","hcfjjafhjiac","ebjchbiifadjjfei","gbfggciea","eebgj","eefdaebhbhhhhii","cheebfbgiihfadgf","acfcbcjgbejcc","dhjjhieidadfdjijehdd","ajdfgi","hhjjfgagebafdfjihd","ibigjccaididd","faejccibjifcgbdcg","cebggffgafdbfi","hefeecdhh"});
        assertEquals(159,ret.size());
    }

}