package sample;

public class AllConstants {
    public static class AbonentsConsts {
        public static final String ABONENTS_TABLE = "abonents";

        public static final String ID = "Номер абонента";
        public static final String FIO = "ФИО";
        public static final String GENDER = "Пол";
        public static final String DATE = "Дата рождения";
        public static final String NUMBER = "Номер телефона";
        public static final String EMAIL = "Электронная почта";
        public static final String ADDRESSPSPT = "Адрес прописки";
        public static final String ADDRESSACT = "Адрес проживания";
        public static final String PASSPORT = "Серия и номер паспорта";
        public static final String SUBDIVISION = "Код подразделения";
        public static final String WHOGAVE = "Кем выдан";
        public static final String DATE_PSPT = "Дата выдачи паспорта";
        public static final String CONTRACT_NUM = "Номер договора";
        public static final String CONTRACT_DATE = "Дата заключения договора";
        public static final String CONTRACT_TYPE = "Тип договора";
        public static final String BREAKREASON = "Причина расторжения договора";
        public static final String PERSONAL_ACCOUNT = "Лицевой счет";
        public static final String SERVICES1 = "Услуги";
        public static final String SERVICES2 = "Услуги_[0]";
        public static final String SERVICES3 = "Услуги_[1]";
        public static final String CONTRACT_BREAK_DATE = "Дата расторжения договора";
        public static final String ARENDAINFO = "Информация об аренде";
        public static final String TECH_ID = "Серийный номер оборудования";
    }

    public static class UsersConsts {
        public static final String USERS_TABLE = "workers";

        public static final String FIO = "ФИО";
        public static final String WORK = "Работа";
        public static final String ID = "ID";
    }

    public static class ServicesConsts {
        public static final String SERVICES_TABLE = "asks";

        public static final String ID = "`Номер заявки`";
        public static final String CREATE_DATE = "`Дата создания`";
        public static final String LS = "`ЛС`";
        public static final String SERVICE = "`Услуга`";
        public static final String SERVICE_TYPE1 = "`Вид услуги`";
        public static final String SERVICE_TYPE2 = "`Тип услуги`";
        public static final String STATUS = "`Статус`";
        public static final String TECH = "`Тип оборудования`";
        public static final String TROUBLES = "`Описание проблемы`";
        public static final String CLOSE_DATE = "`Дата закрытия`";
        public static final String TROUBLE_TYPE = "`Тип проблемы`";
    }

    public static class OMCConsts {
        public static final String OMC_TABLE = "OMC";

        public static final String ID = "Серийный номер";
        public static final String NAME = "Название";
        public static final String RATE = "Частота";
        public static final String COEFF_FADE = "Коэффициент затухания";
        public static final String DTT = "Технология передачи данных";
        public static final String PLACE = "Расположение";
    }

    public static class OAConsts {
        public static final String OA_TABLE = "OA";

        public static final String ID = "Серийный номер";
        public static final String NAME = "Наименование";
        public static final String PORTS_NAME = "Порты";
        public static final String DTS = "Стандарт передачи";
        public static final String DTSpeed = "Скорость";
        public static final String PLACE = "Адрес абонента";
    }

    public static class OSDConsts {
        public static final String OSD_TABLE = "OSD";

        public static final String ID = "Серийный номер";
        public static final String NAME = "Наименование";
        public static final String PORTS_NUM = "Количество портов";
        public static final String DTS = "Стандарт передачи данных ";
        public static final String RATE = "Частота";
        public static final String INTERFACES = "Интерфейсы";
        public static final String DTSpeed = "Скорость";
        public static final String PLACE = "Место расположения";
    }

    public static class Debters {
        public static final String DEBT_TABLE = "abonentsrates";

        public static final String LS = "ЛС абонента";
        public static final String RATE1 = "Тариф абонента";
        public static final String RATE2 = "Второй тариф";
    }

    public static class COMB_RATES {
        public static final String RATE_TABLE = "comb_rates";

        public static final String NAME = "Комбинированный тариф";
        public static final String PRICE = "Стоимость";
    }

    public static class RATES {
        public static final String RATE_TABLE = "rates";

        public static final String NAME = "Название тарифа";
        public static final String PRICE = "Стоимость, руб/мес";
    }

    public static class PAYS {
        public static final String PAYS_TABLE = "abonentspays";

        public static final String DATE = "Дата платежа";
        public static final String SUM = "Сумма платежа";
        public static final String BALANCE = "Баланс абонента";
        public static final String DATE_BALANCE = "Дата баланса";
        public static final String DEBT = "Задолженность";
        public static final String ABONENT_ID = "Номер абонента";
    }
}