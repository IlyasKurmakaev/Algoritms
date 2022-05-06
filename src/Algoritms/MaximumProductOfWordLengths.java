//Task318. Medium Maximum Product of Word Lengths
//Runtime: 259 ms, faster than 23.71% of Java online submissions for Maximum Product of Word Lengths.
//Memory Usage: 116.2 MB, less than 12.86% of Java online submissions for Maximum Product of Word Lengths.
package Algoritms;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class MaximumProductOfWordLengths {
    public int maxProduct(String[] words) {
        Arrays.sort(words, new StringLengthSort());
        int firstWordLength;
        int secondWordLength;
        int bestResult = 0;
        int wordArrLength = words.length;
        for (int iStart = 0; iStart < wordArrLength; iStart++) {
            for (int jEnd = iStart + 1; jEnd < wordArrLength; jEnd++) {
                if (iStart== 100) {
                    System.out.println();
                }
                firstWordLength = words[iStart].length();
                secondWordLength = words[jEnd].length();
                if ((firstWordLength * secondWordLength) <= bestResult) {
                    if (iStart == (jEnd - 1)) {
                        return bestResult;
                    }
                    continue;
                }
                if (itsWordsWithUniqueSymbols(words[iStart], words[jEnd])) {
                    bestResult = firstWordLength * secondWordLength;
                } else {
                    continue;
                }
            }
        }
        return bestResult;
    }


    public boolean itsWordsWithUniqueSymbols(String firstWord, String secondWord) {
        int firstWordLength = firstWord.length();
        for (int i = 0; i < firstWordLength; i++) {
            if (secondWord.contains(firstWord.substring(i, i + 1))) {
                return false;
            }
        }
        return true;
    }

    class StringLengthSort implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return o2.length() - o1.length();
        }
    }


    @Test
    public void commonKey1() {
        Assert.assertEquals(16, maxProduct(new String[] {"abcw","baz","foo","bar","xtfn","abcdef"}) );
    }

    @Test
    public void keyWithLongVariables() {
        Assert.assertEquals(22, maxProduct(new String[] {"gdocnidllpfeiidcbkmcnjpekdddmochfeejiigdheajakbgomaailgpkkbjklkjphgdiakapemgpgabghlljfmjbbpapaefkjdak","dhcknhfdbkailejimmfgdaglhjbcifolgpfaaejkmkelanag","agpefkipapiaenhcbglgnjhiebkgfghlfejiaooknboecjlffoofioeeghmedbegjamifldlom","gljkghbjbhkkgileinhbbkchphhhc","pfholmojemdpnbampchnlah","fbnonaocgbdoagkbjlmhkbheepofcacmaflelambcgpnjfjeplgjbmncibdgenjkjgmfgog","ekonfgmjandiokigkgmpmeaadeheel","agpaomhhlppdonpcjfipmlekpjnhnjokblknjklkfacagjjejpkbkefdfclgfnkpjocmaj","fhlopfbmfkpkcafliplkpbfjhgfndcnfeokmodpiobm","elboldogngpdmlildkjnmomojdibpdncopjaacjjocjoncginloknajbnnlmocfckhphldfkmphanloo","hjdifjnakflcpcbeekhcoebohgbdhodjn","kilhmlkmmmbcimagjgm","jookcalodcfjiegldblk","dpdppeenkalkfgklkjccifbddlmageokiepcgkgaccp","jgbcdgoplockhfmecfb","ceonaenpjoebnfmdnnjbamccjbhmnpaoaolcjekdohpclajojcgcmhcaiphkoleggeecheceimhaiepmiimegaajdcj","ckklhboflogekfncahibonfomeikgjo","eibmfkldplkkmiilidfpdnkchgeghiedkbfenjdmdnnoihobdaomgaengfepbedmmconjcaeghnokcdcabib","icgjcdjpjmgidmahcfffjjijicpbmkebohiajbfjhcbaeodgemoocnmhenellllfonfplkoocak","pmpejblbjkehmgibhmnfocoljlhbihnekcgpgejmnhofbpldgibioakniiiceep","mmkjnmfllaeooehlhhlejedbbpjipapmbfpibgcdmcji","lepedhdcdmlhpnpialcffaplidpflbkdbnpam","mfihoplepleilkcgfjmcjgmbodkhgfkpkdcjlkhoieghehcpmakpdfgkffmmohohpmebjpenmifnphnlpifaolonlc","dbgmecldegbhnjdbmbb","dpcdfblbddiiemijiddbfoibbojmmkcnppcbjcoafifk","fhndcbpbnnlinjlcipnnjikocdikjbijpinkphhmhpianbcacdnelkllkoinghbdbhkjogiegkpihpbllpplamend","nphbhjkeaablhgifopmnfikbekehfjoobmkaphoodkiigoocfkbaokihjamlbbbpme","fafhamofldpbnbpfdjacjgnacind","jpckingakeofoijbjnjlpoaomlhlblncaiciibelmcfhaagomhklggmpfidlfbconencpgj","pmgiejneeijklljmhfanfnndhabkajkecmcldegkjnabnldodfhhplicmkgibaajladebdnbbbmmjlnlnmpaicglhpgpefp","jiacoojabpgieligpedpfmjhmfffeii","fcfjleennidcngccdphpdekfebhimdfekkljfdcodcffpjdogkahcjjjkacbimmockoeobabcikgpfdifnpogcfeamcnpljb","adeboflmaghdadkhpngpppndmlinikdfheccgdephjjkcojjmipfkhnkjdohnfbmglp","modfcdkmgmnkmdcpaoakngbonekchpclndhmepijnhgmmgimignac","egjflmpchnmfhghfldcnpandaefohnmjlnkpdobgegjinlmbohfolnjikohadamimmmfidfheedf","ldfpomgdngjodbjcaaebgjfmdepb","mnhapgbnkglehifjjilkodmdmcipggncapbmnkcakghdnmbfldlpeeaeogniajbjdpllaaceiknchbkh","pmklpkanghcnmipnfepneel","lbdmebcjikjldkpnnhebfbkcndooellfgpbcdokmgbfedhfggmnhgcdjgmemdpnncedpbkhpaaaaelffgpijdhlhfpiochhggoo","cimcacjahbmpkilfmkjpchpglanphmajmnmjfdnnnemjcbkphjbkmmdbppkljnplballcfcngaannhpioiilldboccjji","eddaplpoceegnemdieneoonkomcfaiejegi","beeoehjdbeokhmcekihnfpjnkenfmhiegfojjcigimpdojengjadmoafkeaghalkalomgp","lbdlphklknldkaifoenibeemibpcpclgmimopmglbehoohnibefe","hdfilacmbeahciihmman","mnfllcmlolejakappanejdinaplieikmppimdfgnbnokdidjmmpknlhdgbdgjjpajemilbfj","jfmianobkafocalipfkdimjoimofblnkl","ecpnoojjgdnkhclocamkeeigdgcpodfjnkkdgfbagjpaojfnglonpdbodibfljgpamhbofnlidfpfnnlfiidncoleknna","cgpidgckgamhpfhjpgaabniaieipmpigcbdljgafeiebnpho","ojhholkmaahdfdhaoeoneakpgngilfnicokjjlpcghgdooghihajgno","mpefgibniimmdpgggimonjmgkhpjgfogbkgpjcgbpinnddpgmhpaf","mhogclefdolmnjehjgidkgkceaofdknlhbjlpdddjcigcbceipjmljdomfghoeebbfodgkdjoghgaopileiijcpblbdjeoaac","ibggmgnojjhgkicknffmhhgnhgmndok","fhpbbkmalfphknckpjpcafopdfhnbjbohcjaifkobahadeoghpenkfaidegpeonaohkofj","hakkhfadibecojfdpcccidcgikfbjconjdgficmphkbe","lhbjoipblfkececccmhifdjabipejoopodnonbgeclfedgmgbkejeigfmadd","icinnjdgfgnhmhfkmpkmilcconldhjkeapglkocplmfjkiaohlebkhloapcodenclomlmlmlgifpcjhedilhohjkpc","mgbmamifhoikehbojnbgcil","ldhkfkajcgocdng","hplolahnkapcohmpbofnpendpndcpeojngeacbmcfmdifdbimkgdoflefeclnjnimdlakcggnkiggiolkllnbl","jlkmhbefoifclponofimafofe","pimpjhclflobnpcfajccajbni","ilpgeefhpldoobmlhmfpocibcmim","gkkfeocokdpoognndfhnhpndcnpj","micgojmfpfnehmlhjaigcegpkbpgikknhdgelfpkpejcdbdfifgdlepimngnoikojijenlm","emcofaadploidipcmalnccnmiegimdigckcimbkonlfanbdljmhgilipmeaeghkbojbiidepcndcammbfkddbiblnjphbk","ljjjeajlonanhgdcfggombfiidpldphlmfhmaalajmdbjine","ojbmmdmoodgedidkbkckjphfcpfkokmflaieiblefjmiafji","djijlldpnnmoppdphcgigoeo","hnjnncfincndoilobppgdbdhnlffhmmbojehocidnffhkhkgmfggaeokeppilk","acehokfnppnooldfogkhbndojfpjchophbodoplebbbhneejanagplhbndfmpeoajipiifeoenhgldl","hj","jfhnfafeopnocgibhohjopmakhaogfhmjcjbhenahpehoddncghdobbcmefnfmjbbidhekklhkpekoch","kboaglapkjmgnjdgafhcbominbajoebgpkfkokbmpdeianecgndhpmcenmhggcegoldmdbcoofhefdaoblidl","nngejbdkjbflghmljpomcbbappefdnlggjjcbhkjchcbhlbkanjinoopilhlcgpmkjpomfocbpkiloogfbcllnjija","nnjnafpdigglkkbcppphechlmgcjleecajpnoaloldjbjkffdibdldndhjdmmhidhopmkopeejpbmdaggakbkmlencoacodckonp","cfpaglkenod","hfebklanpfepbpe","lbmekkahbceggkbmhgeahngkeepjjfnppddageacjkkklnagjmfpbfnkdgiebmalenmopbpjggjkpoaoiflnloeln","ncfgkmmchblfhobhhelpbiogoeamegljmmcpkgnhbkfaiehcofnafbaej","ppmjieodijaaiikmljckmeknagjociabjkfml","ccjoifcnnbeohbjgphomlmpomeignionjlelkccfbhbdpcnmfobihlcomii","lmbjdhkgnboienkgappncgbojinldkiklmaaaffenbbpcdodncombb","madhnihaicigckoldmpmniogjglpakdkpconhomnmlknjnhjcbmcbppglmlppekbamnjbefbkhdaj","epjlohphpecmhhpadfoignomjloaafiamncedlhihodlhdcjpcegedpiebmfbcnofacmhml","lbmhnjjpjgjmaoipffcpimdhelejgfdaaeimajkfjoembjdkikpl","aaikdamdmhkmpcodhbamk","foonflpjdpokgomjdbfegbpchfpkmfg","phkhklhieckkfgodbfaolcppibfmefdhjoficommjcmbccdbidopdjgcodbeemepdakcpbojelhinpobcdciom","plmbogahgldkfffhebbkkelfdoaceloenepimdpadnimfjfemheghnohjonnfbkmngikckbmloejohbbgkpfijjjaldnjah","ogaojibgpjnhhknodibejndfphnmiolikplakjlomjnmnfpigncgccnlcpfjinjidomgcpcfcoceljlmjfmhjkpahhcpiefd","gbiglaopbekamlenjdaplmglagjifinndhklimoloknnjpfpbfglgkfkenkfmbkhgnljfngnmhmhkhcbkamplpmjdb","jaiehenfjnhkbeogefelobcoeklhjffkdeghofekccfpcjgaachkc","oamoffahljpciegohabccooigoojlhdohgdofkldfohoahejgddcfigahe","ebhnhbcdjleaeljpgamnemcljinhhedhlmngeahbpdogkmihdafmdnjnacih","lhkhmkccpggjcbnlgmdinglidbgpfchpfopjabliblceahgkijolmjaldfohnahhllhmnfmlgmobpnmen","gjichlepdcdlaocknmdlgnhnbnmfne","mkjmgibigiobobhcjhcaa","albkcnhbabpecomddgbddkmeinicngjcfoncijpfebmcfjbkemkelelakbnblhpdgjmecbpfaklgnnedpndfcooimj","mbannmpjjbmoefoeojhnhlfbddmhhpgeenmml","iaiigjjaammfbgjdgjejlnhemlceddgclohmnpjceljlpi","bjhhdhndffbaonemgdddnlpmfofld","pokdifalolpeikpdjdnodfjdjfejdlgmllhohaklhnffcijpdenhodddjaealphdpmgbfbbjjnlljbmjleoiclkpefhdjfnnp"}) );
    }
}
