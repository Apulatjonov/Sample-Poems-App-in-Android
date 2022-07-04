package com.example.a5task8las

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_blank.view.*
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_main.view.*
import java.io.Serializable
import java.util.ArrayList

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MainFragment : Fragment() {
    lateinit var sevgisherlar: MutableList<Sher>
    lateinit var missingsherlar: MutableList<Sher>
    lateinit var tabriksherlar: MutableList<Sher>
    lateinit var parents: MutableList<Sher>
    lateinit var friends: MutableList<Sher>
    lateinit var jokes: MutableList<Sher>
    lateinit var yangilar:MutableList<Sher>
    lateinit var saved:MutableList<Sher>
    lateinit var resp:String
    private var param1: String? = null
    private var param2: String? = null
    lateinit var root:View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        loadData()
        var list= mutableListOf<Sher>()
        resp = ""
        if (arguments != null) {
            resp = arguments?.getString("resp")!!
            list = arguments?.getParcelableArrayList("1")!!
        when(resp) {
            "1" -> {
                sevgisherlar = list
            }
            "2" -> {
                missingsherlar = list
            }
            "3" -> {
                tabriksherlar = list
            }
            "4" -> {
                parents = list
            }
            "5" -> {
                friends = list
            }
            "6" -> {
                jokes = list
            }
        }
        }
        root = inflater.inflate(R.layout.fragment_main, container, false)
        root.firsteverwhatever.setOnClickListener {
            val bundle = Bundle().apply {
                putParcelableArrayList("1", sevgisherlar as ArrayList<out Parcelable>)
                putString("resp", "1")
            }
            root.findNavController().navigate(R.id.blankFragment, bundle)
        }
        root.secCard.setOnClickListener {
            val bundle = Bundle().apply {
                putParcelableArrayList("1", missingsherlar as ArrayList<out Parcelable>)
                putString("resp", "2")
            }
            root.findNavController().navigate(R.id.blankFragment, bundle)
        }
        root.thirdCard.setOnClickListener {
            val bundle = Bundle().apply {
                putParcelableArrayList("1", tabriksherlar as ArrayList<out Parcelable>)
                putString("resp", "3")
            }
            root.findNavController().navigate(R.id.blankFragment, bundle)
        }
        root.fourthCard.setOnClickListener {
            val bundle = Bundle().apply {
                putParcelableArrayList("1", parents as ArrayList<out Parcelable>)
                putString("resp", "4")
            }
            root.findNavController().navigate(R.id.blankFragment, bundle)
        }
        root.fifthCard.setOnClickListener {
            val bundle = Bundle().apply {
                putParcelableArrayList("1", friends as ArrayList<out Parcelable>)
                putString("resp", "5")
            }
            root.findNavController().navigate(R.id.blankFragment, bundle)
        }
        root.sixthCard.setOnClickListener {
            val bundle = Bundle().apply {
                putParcelableArrayList("1", jokes as ArrayList<out Parcelable>)
                putString("resp", "6")
            }
            root.findNavController().navigate(R.id.blankFragment, bundle)
        }
        root.news.setOnClickListener {
            val bundle = Bundle().apply {
                putParcelableArrayList("1", saved as ArrayList<out Parcelable>)
                putString("resp", "7")
            }
            root.findNavController().navigate(R.id.blankFragment, bundle)
        }
        root.saveds.setOnClickListener {
            val bundle = Bundle().apply {
                putParcelableArrayList("1", yangilar as ArrayList<out Parcelable>)
                putString("resp", "8")
            }
            root.findNavController().navigate(R.id.blankFragment, bundle)
        }
        return root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MainFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    private fun loadData() {
        sevgisherlar = mutableListOf()
        missingsherlar = mutableListOf()
        tabriksherlar = mutableListOf()
        parents = mutableListOf()
        friends = mutableListOf()
        jokes = mutableListOf()
        sevgisherlar.addAll(listOf(Sher("Men uchun ham o`zingni asra", "Sevdim degan so`zingni asra,\n" +
                "Meni kutgan ko`zingni asra,\n" +
                "Seni topgum, yoningga borgum,\n" +
                "Men uchun ham o`zingni asra.\n", false), Sher("Sizni o’ylab-o’ylab bugun ham o’tdi", "Tun cho’kib borliqni domiga yutdi.\n" +
                "Kimdur meni eslab, kimdur unutdi.\n" +
                "Yuragim eridi shirin tush kabi,\n" +
                "Sizni o’ylab-o’ylab bugun ham o’tdi.", false), Sher("Sizni qattiq sevgan yurak sizniki!", "Uyqusiz tunlarim qalbim sizniki,\n" +
                "Ko’zimning yoshi ko’nglim sizniki,\n" +
                "Shiring orzularim dardim sizniki,\n" +
                "Sizni qattiq sevgan yurak sizniki!", false), Sher("Men seni sevardim, sevaman hamon", "Yo’q seni unitmoq emasdur oson.\n" +
                "Qalbimni o’rtaydi hali ham hijron.\n" +
                "Yurakda bir tuyg’u uradi hamon,\n" +
                "Men seni sevardim, sevaman hamon", false), Sher("Sensizlikka o’ganib qoldim", "Sen yo’q sensizlikka o’rganib qoldim,\n" +
                "Ungacha ayriliq o’tida yondim.\n" +
                "Hammadan, hattoki o’zimdan toldim,\n" +
                "Endi sensizlikka o’rganib qoldim.\n", false), Sher("Senku, sevgim, bo’lajak yorim!!!", "Tunlar uxlay olmay o’ylayman seni,\n" +
                "Kunduz uchratolmay o’ylayman seni.\n" +
                "Barcha she’rlarimda so’ylayman seni\n" +
                "Senchi, sevgim, eslaysanmi hech!\n", false), Sher("SMS yozsangu, yozmasa yomon", "Birovni sevsangu sevmasa yomon\n" +
                "Kimnidir kutsangu kelmasa yomon.\n" +
                "Hajrida yonsangu bilmasa yomon\n" +
                "SMS yozsangu, yozmasa yomon.", false), Sher("Nechun kelmading…???", "Seni kutdim, kutdim ko’p uzoq\n" +
                "Yo’llaringga ko’zlarim mushtoq\n" +
                "Kelishingdan aylabon ogoh\n" +
                "Bevafo yor nechun kelmading?\n", false), Sher("Ashaddiy yurakni ko’rmasang bo’ldi.", "Saodat soqmogin izlayin uzoq,\n" +
                "Sen baxting yo’lidan toymasang bo’ldi.\n" +
                "Menga ko’p ko’rindi sevgidan qiynoq,\n" +
                "Sen ishqning sururin qo’ymasang bo’ldi.\n", false), Sher("Kimgadir shodliksan, kim uchun qaygu…", "Borliqni jumbushka keltirsang nima\n" +
                "Sengamas do’stlikka ko’nglim ochardim\n" +
                "Tutqunlik odati axir senga xos.\n" +
                "Erkinlik dardida sendan qochardim.\n", false)))
        missingsherlar.addAll(listOf(Sher("SOG‘INISH", "U uzoq joylarga qilmasdi safar,\n" +
                "To‘kmang derdi ko‘zdan jolalarimni.\n" +
                "Derdi: Bir kungina ko‘rmasam agar\n" +
                "Sog‘inib qolaman bolalarimni.\n", false), Sher("MENI  ESLAYSANMI?", "Meni eslaysanmi, oy tilib-tilib,\n" +
                "Qiyqimlagan baxmalim – yalpiz?\n" +
                "Kimni izlayapsan, chuvalchang bo‘lib\n" +
                "O‘rmalab ketgan ildiz?\n", false), Sher("Sog`inch", "Sog`inch sochlari oqarib ketgan\n" +
                "Ishonchning ko`ksiga toshlar yig`laydi\n" +
                "Ishonchning qo`llari endi kesilgan\n" +
                "Baxtimning boshini gumon silaydi", false), Sher("SENI SOG‘INIB", "Qorako‘z qaldirg‘ochoyimsan o‘zing,\n" +
                "Ko‘ksim ayvon bo‘ldi seni sog‘inib.\n" +
                "Ko‘zimdan bir lahza ketmadi ko‘zing,\n" +
                "Ko‘zim giryon bo‘ldi seni sog‘inib.", false), Sher("* * *", "Sensiz yolg’izdayman bu keng dunyoda,\n" +
                "Quyoshsiz huvillab qolganday osmon.\n" +
                "Go’yo yashayapman sensiz ro’yoda,\n" +
                "Sog’inch yuragimni o’rtar beomon.", false), Sher("Ma'sud", "Seni o‘ylayapman...\n" +
                "Qaydadir sen ham,\n" +
                "Olis yulduzlarga\n" +
                "Termulasan jim...\n" +
                "Kimnidir kutasan\n" +
                "Intiqib shu dam.\n" +
                "Men hali bilmagan,\n" +
                "Dilgir malagim.", false)))
        tabriksherlar.addAll(listOf(Sher("Ketmasin ishonch", "Yangi kun keltirsin baxt, omad, quvonch,\n" +
                "Hech qachon do’stlardan ketmasin ishonch,\n" +
                "Samimiy bo’lsin suhbatda so’zlar,\n" +
                "Yoshlansa quvonchdan yoshlansin ko’zlar.\n" +
                "Yaxshi so’z maqtovlar yangrasin doim,\n" +
                "Omad yaqin do’stingiz bo’lsin, ilohim.", false), Sher("Eng shirin orzularni tilayman sizga", "Muborak ayyomning tiniq tongiday,\n" +
                "Musaffo ranglarga to’lganda borliq.\n" +
                "Xushbo’y tabiatning yetti rangiday,\n" +
                "Osmon gardishida qolganda yorliq.\n" +
                "Eng porloq tuyg’ularni tilayman sizga,\n" +
                "Eng shirin orzularni tilayman sizga.\n" +
                "Tug’ilgan kuningiz bo’lsin muborak!", false), Sher("Aziz insonimga Hayit muborak!", "Ushbu kun Olloxning inoyatidir,\n" +
                "Barcha duolarning ijobatidir,\n" +
                "Hamrohingiz bo’lsin eng ezgu tilak,\n" +
                "Aziz insonimga Hayit muborak!", false), Sher("Har kuningiz o’tsin bayramday har on!", "Baxor chechaklari bo’lsin armug’on,\n" +
                "Siz nurli insonsiz baxtli begumon,\n" +
                "Bayramla qutlayman bo’ling shodumon,\n" +
                "Har kuningiz o’tsin bayramday har on!\n" +
                "Tug’ilgan kuningiz muborak bo’lsin!", false), Sher("Sizdek insonlarni ko’proq yaratsin!", "Tilaklar ichida izlab topganim,\n" +
                "Alloh nigohini sizga qaratsin.\n" +
                "Yagona o’tinchim Allohdan bu kun,\n" +
                "Sizdek insonlarni ko’proq yaratsin!\n" +
                "Tavallud ayyomingiz qutlug’ bo’lsin!", false), Sher("Kulib yuring, kulishdan qismasin Xudo", "Keraksiz insonga aylanmang aslo,\n" +
                "Keraksiz bo’lishdan asrasin Xudo!\n" +
                "Baxt-u saodatdan etmasin judo,\n" +
                "Kulib yuring, kulishdan qismasin Xudo!\n" +
                "Tug’ilgan kuningiz bilan, qadrdonim!", false)))
        parents.addAll(listOf(Sher("SODDA TILAK", "Har kimning ham sochlariga oq tushsin,\n" +
                "Ajin tushsin yuzlariga, dog‘ tushsin.\n" +
                "Har kimning ham quvvat ketib belidan,\n" +
                "Qo‘llariga aso — bir tayoq tushsin.", false), Sher("Ota ona", "Bir kam dunyo havasiga berilib\n" +
                "Sherman deya ozroq pulga kerilib\n" +
                "Aroq vino mayshatlarga berilib\n" +
                "Otamjonim qadrin bilmabman\n" +
                "Onamjonim dardin so'ramabman", false), Sher("Ona", "Dunyoda neki g'am boridan totgan.\n" +
                "Tashvishlar zarbidan yelkasi qotgan.\n" +
                "Necha bir tonglari uyqusiz otgan.\n" +
                "Ey Tangrim besh kunlik yorug' dunyoda.\n" +
                "Onamning umrini qilgin Ziyoda.", false), Sher("Onamni asragin yo Qodir Egam.", "Dunyoda yashayman shodonu, beģam,\n" +
                "Yaratganlar to'rt mucham soģlomu, bekam.\n" +
                "Olamni kõrishga musharraf qilgan\n" +
                "Onamni asragin yo Qodir Egam.", false), Sher("Она сизни яхши кораман", "Тунни улаб тонгларга\n" +
                "Мехир бериб онгларга\n" +
                "Етказиб йоронларга\n" +
                "Она сизни яхши кораман", false), Sher("Oanm", "Oyog'ingiz ostidan\n" +
                "Jannat izlayman\n" +
                "Dunyolardan kechib\n" +
                "SIZNI xoxlayman\n" +
                "Dunyoda yagonam\n" +
                "Borlig'im onam", false), Sher("ONA NOLASI", "Bir yil bo'ldi xabar olmaysan\n" +
                "Qo'ng'iroqqa javob bermaysan.\n" +
                "Bolam!ko'zim qoldi yo'lingda\n" +
                "Nega meni hech yo'qlamaysan?!", false)))
        friends.addAll(listOf(Sher("Do'stlik", "DO’STLIK O’ZI BIR SHISHA,\n" +
                "SINSA ASLO TIKLANMAS.\n" +
                "DO’STLIGIMIZ CHIN BO’LSA,\n" +
                "UNI HECH KIM SINDROLMAS.", false), Sher("Chin do'st", "Og'ir kunda tirgak do'st,\n" +
                "Havotirda sergak do'st,\n" +
                "100 ta dushman oldida,\n" +
                "Qochmas aslo erkak do'st!", false), Sher("Не қайғурмай, дўстимгa", "Душманлари кўп бўлса,\n" +
                "   Мева дарахти сўлса,\n" +
                "Ичи қайғуга тўлса,\n" +
                "   Не қайғурмай, дўстимга…", false), Sher("АЙРИМ ДЎСTЛАРГА", "Сиз ишонинг бурда нонингиз,\n" +
                "Менга асло –асло керакмас.\n" +
                "Сиз юрган йўл бутунлай бошқа,\n" +
                "Сизнинг йўлак бизнинг йўлакмас.", false), Sher("DO'ST", "Men qandayin do'st bo'ldim chin do'stim uchun,\n" +
                "og'ir paytda do'stimni tashlab ketdim-a,\n" +
                "o'ylamadim ahvoli ne kecharkan deb,\n" +
                "shunchalar nomard do'st ekanman bildim.", false), Sher("Kerakmas senday dostlar", "Kerakmas sendayin yuz burgan\n" +
                "Kerakmas wundayin koz korgan\n" +
                "Kerakmas boyligu mansabin\n" +
                "Kerakmas kechirim sozlarin\n" +
                "Kerakmas sendayn doslar", false), Sher("Lolajon", "Lolajon\n" +
                "Beun og’rinasan ko’nglim sezadi\n" +
                "Nega bunchalar mayussan lola\n" +
                "Suyangani do’sting yo’qmi yo dona\n" +
                "Lola , lolajon yolg’izim lola\n" +
                "Mudom qarasam boshing egik hol\n" +
                "Yolg’izlik seni ham qildi xasta xol\n" +
                "Qalbimdan lolalar uzgim olaqol", false), Sher("Mening ko`nglim", "Men va tun\n" +
                "Sokin tun\n" +
                "Sokin tun\n" +
                "Nega dunyo dun\n" +
                "Kunga boq\n" +
                "Kun beorom\n" +
                "Yig’layman yum-yum\n" +
                "Men ezgulik farzandi\n" +
                "Edimku butun\n" +
                "Bir soddadil ko’nglimla\n" +
                "G’amliman nechun", false)))
        jokes.addAll(listOf(Sher("TURG‘UNBOY", "Ish axtarib Turg‘unboy\n" +
                "Necha kunki sarsondir.\n" +
                "Omadining teskari\n" +
                "Yurishidan hayrondir.\n", false), Sher("SHOIR", "E’lon ossang agar biror shaharda,\n" +
                "Esi butun odam kerak deb shu on.\n" +
                "Taloto‘p bo‘lgandek ro‘zi mahsharda,\n" +
                "Yopirilib kelardi odamlar g‘ujg‘on.\n", false), Sher("ADMIN VA BURGA", "Yaqin o'tgan zamonda, allaqaysi tomonda,\n" +
                "Odam bilmas bu zamin yashar ekan sisadmin.\n" +
                "Eski kompi yonida o'ltirarkan erta kech,\n" +
                "Viruslar-u yuzerlar tich qo'ymaslar uni hech.\n" +
                "Xatto ba'zi vaqtlar ovqat yemas, ichmas choy,\n" +
                "Bosh qashlashga yo'q fursat, tanlamaydi uyqu joy.\n" +
                "Shunday kunlar birida ko'z qizargan, qorin och\n" +
                "Bosh qashladi sisadmin:\n" +
                "(Po'stak bo'lib ketgan soch).\n" +
                "Monitorda hayoli, bir qo'l sichqon qidirar,\n" +
                "Birida boshdan tolgan kichik burga pitirar.", false), Sher("Stipendiya", "DO'STLAR SEROB BO'LIB QOLADI\n" +
                "DOMLALARHAM QO'LING OLADI\n" +
                "QALBDA QUVONCH YOG'DU SOLADI\n" +
                "STIPENDIYA OLGAN KUNINGDA", false), Sher("Zamonaviy sevgi izhori", "Xayolimdasan uyquga qadar,\n" +
                "Xayolimdasan uyg'onsam sahar.\n" +
                "Hatto tushlarimda ko'raman seni\n" +
                "Shirin tushlarimga qo'shasan zahar!", false), Sher("Erkak", "Garchi shuncha mag'rur tursa ham,\n" +
                "Ayoliga egilar erkak.\n" +
                "Shunday ekan manmanlik nechun,\n" +
                "Ularga riyo nimaga kerak.?\n", false)))
        yangilar = mutableListOf()
        yangilar.addAll(listOf(Sher("O'zbek paxtasi", "Dunyoda qutlovlar bor\n" +
                "Biri biridan go‘zal,\n" +
                "Dunyoda tabriklar bor\n" +
                "Biri biridan ezgu.\n" +
                "Va lekin bu olamda\n" +
                "Topilmas hech bir mahal\n" +
                "Ona-yurt qutlovidan\n" +
                "Balandroq biror tuyg‘u.", false), Sher("O'zbegim tojik bilan!", "Do‘stu qardoshdir azaldan\n" +
                "O’zbegim tojik bilan,\n" +
                "Ikkisi bir bayt g‘azaldan\n" +
                "O’zbegim tojik bilan.", false), Sher("O'zbekman", "Yangi bir asrning ostonasi bu,\n" +
                "Yetishdim umrimning qutlug‘ yoshiga.\n" +
                "Tilimda shukrona, dilimda g‘ulu,\n" +
                "Tarix sarkotibin keldim qoshiga.", false), Sher("O'zbek onasi", "Mushtipar ham o‘zing, buyuk ham o‘zing,\n" +
                "Kuyinchak ham o‘zing, kuyuk ham o‘zing,\n" +
                "Olamga tatirlik suyuk ham o‘zing,\n" +
                "Payt keldi aytmoqqa, gapning xonasi,\n" +
                "Ey, o‘zbek onasi, o‘zbek onasi.", false), Sher("Xalq", "Hamma narsa o‘tadi, mansab, shonu shavkat ham,\n" +
                "Shirindan shirin qolur, talxdan esa qolur talx.\n" +
                "Bir kuni tuproq bo‘lur, tengsiz shamsi tal’at ham,\n" +
                "Faqatgina xalq yashar, faqatgina qolur xalq.", false), Sher("Xalq naqli", "Xalq naqlni to‘qimaydi atayin,\n" +
                "Naqllarning umri fuzun bo‘ladi.\n" +
                "Mana, sizga bittasini aytayin:\n" +
                "Yaxshilik qil - tiling uzun bo‘ladi.", false), Sher("Ma'sud", "Yolg‘izoyoq yo‘lda horg‘in, o‘y surib,\n" +
                "Barcha xo‘rliklarni dildan olib tan,\n" +
                "Haqiqat shahridan qadamin burib,\n" +
                "Tubanlik sorig‘a ketmoqda Vatan.", false), Sher("Izhori dil", "Ko'hna tol beshikdan\n" +
                "Boshlangan olam.\n" +
                "Senga iddaolar\n" +
                "Qilmay sevaman\n" +
                "Bir kuni singlim deb\n" +
                "Bir kuni onam-\n" +
                "Vatan\n" +
                "Kimligingni\n" +
                "bilmay sevaman.", false)))
        saved = mutableListOf()
        saved.addAll(listOf(Sher("Uqtirish", "Unga uqtirdilar,\n" +
                "Oqni qora deb.\n" +
                "Chunki bir qorani,\n" +
                "Oqlash lozim edi.", true), Sher("Xatolaring kerak ularga", "Shundaylar bor,senga lutf aylab,\n" +
                "DoТstman, deya senga qoТlin tutarlar.\n" +
                "Lekin har zum qadaming poylab,\n" +
                "Xato qilishingni kutarlar.", true), Sher("Birinchi muhabbatim", "Dunyo degan shundayin anglab boТlmas sir ekan,\n" +
                "Goh keng ekan, gohida tuynuksiz qasr ekan,\n" +
                "Lekin inson hamisha bir hisga asir ekan,\n" +
                "Nechun bilmovdim avval, birinchi muhabbatim,\n" +
                "Parvo qilmovdim avval, birinchi muhabbatim", true), Sher("Ketmoqdaman", "Yaxshi qol, ey, dilbarim, dilda kadar, ketmoqdaman,\n" +
                "Ishq aro endi holim zeru zabar ketmoqdaman.\n" +
                "\n" +
                "Na ishonchu na quvonchu na ko'ngildan gapni och,\n" +
                "Barchasidan ushbu kun yo'qdir samar, ketmoqdaman.", true), Sher("Onajon", "Necha kunki yo`q oromim\n" +
                "Kelolmayman hushimga.\n" +
                "Onajonim kechalari\n" +
                "Kirib chiqar tushimga.", true), Sher("Shoir yuragi", "O'tar bu ko'prikdan jamiki jonzod,\n" +
                "Chumolidan tortib fillar ham o'tar.\n" +
                "Sultonlar o'tadi goh shod, goh noshod,\n" +
                "Zanjirlarin sudrab qullar ham o'tar.", true), Sher("Xato qilishingni kutarlar", "Shundaylar bor, senga lutf aylab,\n" +
                "Do'stman, deya qo'lin tutarlar.\n" +
                "Lekin har zum qadaming poylab,\n" +
                "Xato qilishingni kutarlar.", true), Sher("Ohu", "Makoning bo'libdi tog'lar orasi,\n" +
                "Sensan go'zallikning asli, sarasi.\n" +
                "Ma'yus yuragingda ishqning yarasi,\n" +
                "Sen ham oshiqmisan yoki, ohujon.\n" +
                "\n" +
                "Daralar qo'ynida neni istarsan,\n" +
                "Nechun doim g'amgin, doim mustarsan.\n" +
                "Latif shijoating qayga qistarsan,\n" +
                "Sen ham oshiqmisan yoki, ohujon.", true)))

        sevgisherlar.add(Sher("Sensizlikka o’ganib qoldim", "Sen yo’q sensizlikka o’rganib qoldim,\n" +
                "Ungacha ayriliq o’tida yondim.\n" +
                "Hammadan, hattoki o’zimdan toldim,\n" +
                "Endi sensizlikka o’rganib qoldim.\n" +
                "\n" +
                "Lek hamon yolg’izman yo’qsan yonimda,\n" +
                "Misli bir azobsan yarim jonimda.\n" +
                "Endi iloji yo’q qaytish yoninga,\n" +
                "Sen yo’q sensizlikka o’rganib qoldim.\n" +
                "\n" +
                "Endi faqat va’dalaring qiynar meni,\n" +
                "Sog’inaman har erta tong o’ylab seni.\n" +
                "Tashlab ketding, o’ylamading jonim meni,\n" +
                "Yolg’izginam, sensizlikka o’rganib qoldim.\n" +
                "\n" +
                "Seni jonim, dunyolarga alishmasdim,\n" +
                "Sendan boshqa go’zallarni hech ko’rmasdim.\n" +
                "O’zga bilan ketishingni men bilmasdim,\n" +
                "Sen yo’q mana sensizlikka o’rganib qoldim.\n" +
                "\n" +
                "Jonim, seni baxtga to’lib sevgandim,\n" +
                "Allox guvox chin dilimdan sevgandim.\n" +
                "Sevgimizni qadriga yetasan deb bilgandim,\n" +
                "Endi kechdir, sensizlikka o’rganib qoldim.\n" +
                "\n" +
                "Mana bugun ajraldik biz ikki tomon,\n" +
                "Ko’rolmasdan sog’inaman seni yomon.\n" +
                "Endi senga qaytolmayman sevsamda hamon,\n" +
                "Sen yo’q sensizlikka o’rganib qoldim.\n" +
                "\n" +
                "Yurak ham yolg’izlikka ko’na boshladi,\n" +
                "Menga aytgan so’zlaring ko’nglim g’ashladi.\n" +
                "Mendan ketmoqlikni ko’ngling hushladi,\n" +
                "Mayli ketgin, sensizlikka o’ganib qoldim.", false))

        missingsherlar.add(Sher("Maylida", "Maylida kimgadur yoqsa yoqmasa\n" +
                "Ularga qo'shilib yig'lasharmidik\n" +
                "Biz baxtli bo'lamiz hudo hohlasa\n" +
                "Hudo hohlamasa uchrasharmidik\n" +
                "Rayhon hidlarini yo'llarimga sep,\n" +
                "Kut meni har oqshom ko'kka oy chiqqan.\n" +
                "Faqat yig'lamagin aybim nima deb\n" +
                "Aybing onang seni chiroyli tuqqan.\n" +
                "Menga bir tabassum hadya et ey yor\n" +
                "Nur tomsin lablaring sohillaridan\n" +
                "O'zing ayt senday qiz yana qayda bor\n" +
                "Kipriklari uzun kokillaridan\n" +
                "Iymanib yashama hayol pinjida\n" +
                "Yoyil yayra jonim o'rtanma g'amda\n" +
                "G'iybatlarga chida tuxmatga chida\n" +
                "Sen axir bittasan yorug' olamda\n" +
                "Men esa oshig'ing sening eng g'arib\n" +
                "Tundan so'z qarz olib tongga tutguvchi\n" +
                "Seni yoningda ham seni axtarib\n" +
                "Seni yoningda ham seni kutguvchi\n" +
                "Ista tiz cho'kaman hozir oldingda\n" +
                "Sevdim sevganimdan uyalmoq nechun\n" +
                "Barcha farishtalar sening qalbingda\n" +
                "Ijaraga turgan qizlar men uchun\n" +
                "Biz baxtli bo'lamiz hudo hohlasa\n" +
                "Hudo hohlamasa uchrasharmidik", false))

        tabriksherlar.add(Sher("O'zimga", "Bugun tug'ilgan kunim\n" +
                "bordur ko'p orzularim\n" +
                "shu orzularimda yashar\n" +
                "mani aziz otajonim\n" +
                "\n" +
                "Men qancha ulg'aysam xam\n" +
                "xatto yuzga to'lsam xam\n" +
                "bir kun kelib o'lsam xam\n" +
                "otajonim sog' bo'lsin\n" +
                "volidam rozi bo'lsin\n" +
                "\n" +
                "Bugun tug'ilgan kunim\n" +
                "bordur ko'p orzularim\n" +
                "shu orzularimda yashar\n" +
                "mani aziz onajonim\n" +
                "\n" +
                "Men azobda qolsam xam\n" +
                "goh dardlardan tolsam xam\n" +
                "bir kun kelib sevsam xam\n" +
                "onamni duosi bo'lsin\n" +
                "kelin onamga qiz bo'lsin\n" +
                "\n" +
                "Bugun tug'ilgan kunim\n" +
                "bordur ko'p orzularim\n" +
                "shu orzularimda yashar\n" +
                "mani yolg'iz sevganim\n" +
                "\n" +
                "Tanho uni sevsam xam\n" +
                "bahtli bo'lsa bahtliman\n" +
                "sevgim o'zgaga bo'lsa xam\n" +
                "men uni sevay xar dam\n" +
                "\n" +
                "Bugun tug'ilgan kunim\n" +
                "bordur ko'p orzularim\n" +
                "shu orzularimda yashar\n" +
                "saytdagi muxlislarim\n" +
                "\n" +
                "Men sizlarni sevarman\n" +
                "sherlarimda yozarman\n" +
                "xar biringiz birdek menga\n" +
                "jonim fidodur sizlarga\n", false))

        parents.add(Sher("Qard", "Yaqiningdan o'zga qadringni bilmas\n" +
                "Ulardan boshqasi dardingni bilmas\n" +
                "So'zlaring eshitib tursada ammo\n" +
                "Yaqinlaring kabi dildan tinglamas\n" +
                "\n" +
                "Ko'chalarda yurgan tanish do'stlaring\n" +
                "O'zin olib qochar ketsa omading\n" +
                "Bir vaqtlar sen bilan bo'lgan bo'lsa do'st\n" +
                "Bugunchi xattoki qaramay o'tar\n" +
                "\n" +
                "Shunday bo'lib qoldi ha bugun zamon\n" +
                "Kimda zo'r daromad yonida do'stlar\n" +
                "Hattoki xech qachon ko'rmaganing ham\n" +
                "Erta kech atrofda tinmay aylanar\n" +
                "\n" +
                "Yo'qchilik qiynasa mag'rur yigitni\n" +
                "Yonida ko'rmaysan u vaqt xech kimni\n" +
                "Tanish bilishlari qocharlar chetga\n" +
                "Xodoyim sinarkan har bir insonni\n" +
                "\n" +
                "Qo'lin cho'zmas ekan akangdan o'zga\n" +
                "Qadringni bilmaydi ukangdan o'zga\n" +
                "Opa singillaring bari do'st senga\n" +
                "Boshqasi begona begona senga\n" +
                "\n" +
                "Otang o'rgatarkan hayot darsini\n" +
                "Yaxshiyu yomoning asl farqini\n" +
                "Eh bilmas ekansan inson mardini\n" +
                "Yoningda bo'lmasa bilarsan qadrin\n" +
                "\n" +
                "Balo qazolarda asragin deya\n" +
                "Erta kech xudoga qilarkan nola\n" +
                "Qadrdon bir bora o'ylab ko'rgin sen\n" +
                "Doyimo bahtingni tilaydi ona\n" +
                "\n" +
                "Maiyshatu daydishlar bari o'tadi\n" +
                "Ular seni hamon har on kutadi\n" +
                "Borida asragin asra borida\n" +
                "Bir kuni ular ham axir ketadi." ,false))

        friends.add(Sher("Ko'ngil", "Мен dostingman кулма устимдан,\n" +
                "Ўз dostingni юлма пўстидан,\n" +
                "Забонингман, тилга тиғланиб,\n" +
                "Ўз ҳажрида ўзи йиғлаган.\n" +
                "\n" +
                "Билсанг, қушман кўкка сиғмаган,\n" +
                "Билсанг, тушман тушга сиғмаган,\n" +
                "Балқиса-да, руҳим самода,\n" +
                "Денгизман мен, сувга сиғмаган.\n" +
                "\n" +
                "Мен бир юрак, қалбга сиғмаган,\n" +
                "Мен бир дардман дардга сиғмаган,\n" +
                "Кун сўнгида кўринган шафақ -\n" +
                "Ғариб ғарбман шарққа сиғмаган...\n" +
                "\n" +
                "Улкан тоғдир ғурурим, шаъним,\n" +
                "Улкан жондир, бу инжа таним,\n" +
                "Ғами кўп деб, кулма, эй dostim\n" +
                "Дунёман senga sigmagan.", false))

    }
}