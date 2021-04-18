package com.wumj.demo.test;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.*;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.sun.deploy.net.HttpRequest;
import com.sun.deploy.net.HttpUtils;
import com.wumj.demo.model.*;
import org.junit.Test;
import org.omg.IOP.ComponentIdHelper;

import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wumj
 * @date 2020-11-19 15:31
 */
public class Test1 {
    @Test
    public void test2() {
        String s = "\n" +
                "\n" +
                "职位描述：\n" +
                "\n" +
                "\n" +
                "1、负责Worktile研发项目管理产品线内容规划与建设。围绕行业、产品特点以及目标客户需求，持续输出优质内容、传递产品价值；\n" +
                "\n" +
                "\n" +
                "2、有能力系统规划并建设技术内容体系，完善内容运营规范和协作流程，拓展内容合作形式，持续优化内容类型与分发策略；\n" +
                "\n" +
                "\n" +
                "3、撰写行业趋势类稿件，向大众普及技术领域专业知识，报道学术界和业界相关技术会议，并可以撰写出有影响力的内容，撰写技术、产品、公司和行业相关文章，对技术人物进行访谈，输出观点；\n" +
                "\n" +
                "\n" +
                "4、微信公众号、知乎机构号等平台运营。结合不同渠道特点，把控选题策划、上线分发、数据分析等各个环节。\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\u200B职位要求：\n" +
                "\n" +
                "\n" +
                "1、本科以上学历，包括但不限于软件工程、广告、市场营销等传播类专业，有技术经验者优先；\n" +
                "\n" +
                "\n" +
                "2、关注新技术与科技行业，较强的产品敏锐度，熟悉工具型产品特点，能够对产品的功能价值进行商业提炼与包装；\n" +
                "\n" +
                "\n" +
                "3、具备2年以上相关工作经验，热爱和了解科技媒体行业，至少了解计算机技术1至2个领域的知识；\n" +
                "\n" +
                "\n" +
                "4、有SaaS类产品/企业级软件/互联网大型产品运营经验优先；\n" +
                "\n" +
                "\n" +
                "5、有敏锐的行业洞察力，优秀的文字功底和独立的深度内容创造力；\n" +
                "\n" +
                "\n" +
                "6、性格外向，乐于分享与交流，保持长期的学习能力和求知欲。\n" +
                "\n" +
                "\n" +
                "7、持PMP、ACP等管理证书优先。\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\u200B具备这些您会特别加分：\n" +
                "\n" +
                "\n" +
                "1、对IT技术行业感兴趣，愿意思考程序员心理和该用户群行为；\n" +
                "\n" +
                "\n" +
                "2、简单、认真，对任务与目标具备实现和完成的渴望，有较强的自我驱动力；\n" +
                "\n" +
                "\n" +
                "3、注重自我学习，喜欢通过分享会、线上课程、运营自己公众号等方式，乐于提升专业能力；\n" +
                "\n" +
                "\n" +
                "4、注重文笔，如随同简历附带您的作品，我们将优先为您启动推荐流程。\n" +
                "\n" +
                "\n" +
                "职位描述：\n" +
                "\n" +
                "\n" +
                "1、负责Worktile研发项目管理产品线内容规划与建设。围绕行业、产品特点以及目标客户需求，持续输出优质内容、传递产品价值；\n" +
                "\n" +
                "\n" +
                "2、有能力系统规划并建设技术内容体系，完善内容运营规范和协作流程，拓展内容合作形式，持续优化内容类型与分发策略；\n" +
                "\n" +
                "\n" +
                "3、撰写行业趋势类稿件，向大众普及技术领域专业知识，报道学术界和业界相关技术会议，并可以撰写出有影响力的内容，撰写技术、产品、公司和行业相关文章，对技术人物进行访谈，输出观点；\n" +
                "\n" +
                "\n" +
                "4、微信公众号、知乎机构号等平台运营。结合不同渠道特点，把控选题策划、上线分发、数据分析等各个环节。\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\u200B职位要求：\n" +
                "\n" +
                "\n" +
                "1、本科以上学历，包括但不限于软件工程、广告、市场营销等传播类专业，有技术经验者优先；\n" +
                "\n" +
                "\n" +
                "2、关注新技术与科技行业，较强的产品敏锐度，熟悉工具型产品特点，能够对产品的功能价值进行商业提炼与包装；\n" +
                "\n" +
                "\n" +
                "3、具备2年以上相关工作经验，热爱和了解科技媒体行业，至少了解计算机技术1至2个领域的知识；\n" +
                "\n" +
                "\n" +
                "4、有SaaS类产品/企业级软件/互联网大型产品运营经验优先；\n" +
                "\n" +
                "\n" +
                "5、有敏锐的行业洞察力，优秀的文字功底和独立的深度内容创造力；\n" +
                "\n" +
                "\n" +
                "6、性格外向，乐于分享与交流，保持长期的学习能力和求知欲。\n" +
                "\n" +
                "\n" +
                "7、持PMP、ACP等管理证书优先。\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\u200B具备这些您会特别加分：\n" +
                "\n" +
                "\n" +
                "1、对IT技术行业感兴趣，愿意思考程序员心理和该用户群行为；\n" +
                "\n" +
                "\n" +
                "2、简单、认真，对任务与目标具备实现和完成的渴望，有较强的自我驱动力；\n" +
                "\n" +
                "\n" +
                "3、注重自我学习，喜欢通过分享会、线上课程、运营自己公众号等方式，乐于提升专业能力；\n" +
                "\n" +
                "\n" +
                "4、注重文笔，如随同简历附带您的作品，我们将优先为您启动推荐流程。\n";
        System.out.println("s = " + s);
    }

    @Test
    public void test03() {
        int huahua = 6000;
        System.out.println("huahua = " + huahua);
        int jiejie = 16000;
        System.out.println("jiejie = " + jiejie);
        System.out.println("totoal = " + (jiejie + huahua));
        System.out.println("-----------------------");
        //12
        int jiejie_yue_12 = jiejie - 550;
        System.out.println("jiejie_yue_12 = " + jiejie_yue_12);
        int huahua_yue_12 = huahua;
        System.out.println("huahua_yue_12 = " + huahua_yue_12);
        System.out.println("total:" + (jiejie_yue_12 + huahua_yue_12));
        int mama12 = 4400 - 550 - 600 - 900;
        System.out.println("mama12:4400(salary)-550(jiejie)-600(life)-900(house) = " + mama12);
        int mama = mama12;
        System.out.println("mama = " + mama);
        System.out.println("-------------------");
        //1
        int jiejie_yue_1 = jiejie_yue_12 - 550;
        System.out.println("jiejie_yue_1 = " + jiejie_yue_1);
        int huahua_yue_1 = huahua_yue_12 - 1000 - 500;
        System.out.println("huahua_yue_1 = " + huahua_yue_1);
        System.out.println("total:" + (jiejie_yue_1 + huahua_yue_1));
        int mama1 = 5400 - 550 - 1500 - 800 - 1300;
        System.out.println("mama1:5400(salary)-550(jiejie)-1500(huahua)-1300(life)-800(house) = " + mama1);
        mama += mama1;
        System.out.println("mama = " + mama);
        System.out.println("-------------------");

        //2
        int jiejie_yue_2 = jiejie_yue_1 - 550;
        System.out.println("jiejie_yue_2 = " + jiejie_yue_2);
        int huahua_yue_2 = huahua_yue_1 - 750;
        System.out.println("huahua_yue_2 = " + huahua_yue_2);
        System.out.println("total:" + (jiejie_yue_2 + huahua_yue_2));
        int mama2 = 5400 - 550 - 750 - 800 - 1300;
        System.out.println("mama2:5400(salary)-550(jiejie)-750(huahua)-1300(life)-800(house) = " + mama2);
        mama += mama2;
        System.out.println("mama = " + mama);
        System.out.println("-------------------");

    }


    @Test
    public void test04() {
        System.out.println(WeekEnum.getDetail(DateTime.of(DateUtil.parseDate("2021-04-17")).dayOfWeekEnum().toString()));

        DateTime yesterday = DateUtil.yesterday();
        System.out.println("yesterday = " + yesterday.toString("yyyy年MM月dd日"));
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
//        String format = simpleDateFormat.format(new Date());
//        System.out.println("format = " + format);
      /*  DateTime now = DateUtil.date();
        String nowDate = now.toString("yyyy-MM-dd");
        System.out.println("nowDate = " + nowDate);
        String nowTime = now.toString("HH:mm");
        System.out.println("nowTime = " + nowTime);*/

        DateTime now = DateUtil.date();
        DateTime dateTime = DateUtil.parseDate("2021-04-15");
        System.out.println("dateTime = " + dateTime);
        System.out.println("0000-----"+DateTime.of(dateTime).dayOfWeekEnum());
        System.out.println("now = " + now);
        String s1 = DateUtil.offsetDay(now, 2).toString("yyyy-MM-dd");
        System.out.println("s1 = " + s1);
//        System.out.println("now.toString(\"yyyy年MM月dd日 HH:mm:ss\") = " + now.toString("yyyy年MM月dd日 HH:mm:ss"));

//String s="2021-04-01 10:33:50";
//        DateTime dateTime = DateUtil.parseDateTime(s);
//        System.out.println(dateTime.toString("yyyy年MM月dd日 HH:mm:ss"));
       /* DateTime dateTime = DateUtil.offsetHour(now, 1);
        String nowDate = dateTime.toString("yyyy年MM月dd日");
        System.out.println("nowDate = " + nowDate);
        String nowTime = dateTime.toString("HH:mm");
        System.out.println("nowTime = " + nowTime);*/

//        System.out.println("2021年04月01日 10:33:50".compareTo("2021年03月31日 16:39:16"));
//        System.out.println("DateUtil.yesterday().toString(\"yyyy-MM-dd\") = " + DateUtil.yesterday().toString("yyyy-MM-dd"));


        //获取当前往后的十五天的时间
    }
    @Test
    public void getBetweenDaysTest(){
//
//            List<String> list = getDetHashList("2021-03-01", "2021-03-15");
////            List<String> list = getBetweenDays("2021-03-01", "2021-03-15");
//            list.stream().forEach(System.out::println);

        Date bDate = DateUtil.parse("2021-03-01", DatePattern.NORM_DATE_PATTERN);//yyyy-MM-dd
        System.out.println("bDate = " + bDate);
        Date eDate = DateUtil.parse("2021-03-15", DatePattern.NORM_DATE_PATTERN);
        System.out.println("eDate = " + eDate);
        List<DateTime> dateList = DateUtil.rangeToList(bDate, eDate, DateField.DAY_OF_YEAR);//创建日期范围生成器
        List<String> collect = dateList.stream().map(e -> e.toString("yyyy-MM-dd")).collect(Collectors.toList());
        System.out.println("collect = " + collect);

    }

    public static List<String> getDetHashList(String begin, String end) {
        List<String> hashList = new ArrayList<>();
        String btime = begin.substring(0, 10);//yyyy-MM-dd
        String etime = end.substring(0, 10);

        Date bDate = DateUtil.parse(btime, DatePattern.NORM_DATE_PATTERN);//yyyy-MM-dd
        Date eDate = DateUtil.parse(etime, DatePattern.NORM_DATE_PATTERN);
        List<DateTime> dateList = DateUtil.rangeToList(bDate, eDate, DateField.DAY_OF_YEAR);//创建日期范围生成器
        String hash = null;
        for (DateTime dt : dateList) {
            hash = dt.toString().replaceAll("-", "_").substring(0, 10);
            hashList.add(hash);
        }
        return hashList;
    }

    public static List<String> getBetweenDays(String startTime, String endTime) throws ParseException {
//        if(StringUtils.isEmpty(startTime) || StringUtils.isEmpty(endTime)){
//            return null;
//        }
        //1、定义转换格式
        SimpleDateFormat df  = new SimpleDateFormat("yyyy-MM-dd");

        Date start = df.parse(startTime);
        Date end = df.parse(endTime);
//        if(StringTools.isEmpty(start) || StringTools.isEmpty(end)){
//            return null;
//        }
        List<String> result = new ArrayList<String>();

        Calendar tempStart = Calendar.getInstance();
        tempStart.setTime(start);

        tempStart.add(Calendar.DAY_OF_YEAR, 1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar tempEnd = Calendar.getInstance();
        tempEnd.setTime(end);
        result.add(sdf.format(start));
        while (tempStart.before(tempEnd)) {
            result.add(sdf.format(tempStart.getTime()));
            tempStart.add(Calendar.DAY_OF_YEAR, 1);
        }
        return result;
    }

    @Test
    public void test05() {
        String s = "{eee,eeee,tttt,yyy}";
        System.out.println(s.substring(1, s.length() - 1));

        List<User> list = Arrays.asList(
                new User(1, 20, "zhangsan"),
                new User(2, 33, "lisi"),
                new User(3, 56, "wangwu"));
        List<Integer> collect = list.stream().filter(e->e.getAge()>30).map(User::getAge).collect(Collectors.toList());
        System.out.println("collect = " + collect);

    }
    @Test
    public void testVerifySquenceOfBST(){
        int[] a={4,8,6,12,16,14,10};
        boolean b = VerifySquenceOfBST(a);
        System.out.println("b = " + b);
    }
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence==null||sequence.length==0){
            return false;
        }
        int trStart = 0;
        int root = sequence.length-1;
        for(int i=0;i<root;i++){
            if(sequence[i]<sequence[root]){
                trStart++;
            }
        }
        if(trStart==0||trStart==root){
            return VerifySquenceOfBST(Arrays.copyOfRange(sequence,0,root));
        }
        for(int i=trStart;i<root;i++){
            if(sequence[trStart]<=sequence[root]){
                return false;
            }
        }

        boolean b = VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, trStart));
        boolean b1 = VerifySquenceOfBST(Arrays.copyOfRange(sequence, trStart, root));
        return b && b1;
    }

    @Test
    public void test09(){
        double r=2;
        System.out.println("r = " + r);
    }

    @Test
    public void test10(){
        Map<String, List<DoctorSchedulingVo>> result = getDoctorHomepageScheduling();
        Iterator<Map.Entry<String, List<DoctorSchedulingVo>>> entries = result.entrySet().iterator();
        while(entries.hasNext()){
            Map.Entry<String, List<DoctorSchedulingVo>> entry = entries.next();
            String key = entry.getKey();
            System.out.println("key = " + key);
            List<DoctorSchedulingVo> value = entry.getValue();
            System.out.println("value = " + value);
            System.out.println("----------------");
        }

    }

    public Map<String, List<DoctorSchedulingVo>> getDoctorHomepageScheduling() {

        List<DoctorSchedulingVo> list= Arrays.asList(
                new DoctorSchedulingVo("2021-04-12","1","20"),
                new DoctorSchedulingVo("2021-04-12","3","20"),
                new DoctorSchedulingVo("2021-04-13","1","20"),
                new DoctorSchedulingVo("2021-04-14","2","20"),
                new DoctorSchedulingVo("2021-04-16","3","20")
        );
        Map<String, List<DoctorSchedulingVo>> resultMap=new HashMap<>();//返回的结果
        DateTime now = DateUtil.date();
        //从今天起的15天的日期，包括今天
        List<String> dayList = getDayList(now.toString("yyyy-MM-dd"), DateUtil.offsetDay(now, 5).toString("yyyy-MM-dd"));
        if (CollUtil.isNotEmpty(dayList)){
            for (String dayItem : dayList) {
                List<DoctorSchedulingVo> item = new ArrayList<>();
                for (int i = 1; i < 4; i++) {//时间片
                    int temp=i;
                    DoctorSchedulingVo itemInfo = null;
                    Optional<DoctorSchedulingVo> first = list.stream().filter(e -> e.getOutpDate().equals(dayItem) &&
                            e.getTimeInterval().equals(String.valueOf(temp)))
                            .findFirst();
                    if (first.isPresent()) {
                        //把optional的值给实体类
                        item.add(first.get());
                    }else{
                        itemInfo = new DoctorSchedulingVo();
                        //TODO 设置对应的无号状态
                        item.add(itemInfo);
                    }
                }
                resultMap.put(dayItem,item);
            }
        }
        return resultMap;
    }

    //获取startTime，到endTime之间的时间
    public List<String> getDayList(String begin, String end) {
        Date bDate = DateUtil.parse(begin, DatePattern.NORM_DATE_PATTERN);//yyyy-MM-dd
        Date eDate = DateUtil.parse(end, DatePattern.NORM_DATE_PATTERN);
        List<DateTime> dateList = DateUtil.rangeToList(bDate, eDate, DateField.DAY_OF_YEAR);//创建日期范围生成器
        List<String> collect = dateList.stream().map(e -> e.toString("yyyy-MM-dd")).collect(Collectors.toList());
        return collect;
    }

    @Test
    public void tets(){
        ArrayList<Employee> list = new ArrayList<>();
        Employee w1 = new Employee("wumj", 23, 7888.0);
        list.add(w1);
        w1 =new Employee("fhw", 18, 8990.0);
        list.add(w1);
        Employee employee = list.get(0);
        System.out.println(employee);
        list.forEach(System.out::println);

        Employee2 employee2 = new Employee2();
        BeanUtil.copyProperties(w1,employee2);
        String age = employee2.getAge();
        System.out.println(employee2);

    }

    @Test
    public void test11(){
        List<MedicalRecordMailPurposeInfoListVo> list = new ArrayList<>();
//        TbMedicalRecordMailPurposeInfo entity=new TbMedicalRecordMailPurposeInfo(1L,1,0L,null);
//        TbMedicalRecordMailReceiveInfo receiveInfoEntity=new TbMedicalRecordMailReceiveInfo(1l,2,3,"323");
//
//        MedicalRecordMailReceiveInfoVo receiveInfo=new MedicalRecordMailReceiveInfoVo();
//        BeanUtil.copyProperties(receiveInfoEntity,receiveInfo);
//        System.out.println(receiveInfo);

//        System.out.println(CollUtil.isEmpty(list));

        List<PatientRegisterdInfoVo> list1=new ArrayList<>();
        PatientRegisterdInfoVo patientRegisterdInfoVo = new PatientRegisterdInfoVo();
        patientRegisterdInfoVo.setHisOrderNo("1111");
        patientRegisterdInfoVo.setCardNo("1111");
        list1.add(patientRegisterdInfoVo);

        patientRegisterdInfoVo = new PatientRegisterdInfoVo();
        patientRegisterdInfoVo.setHisOrderNo("2222");
        patientRegisterdInfoVo.setCardNo("2222");
        list1.add(patientRegisterdInfoVo);


        //判定数据一致性
        Optional<PatientRegisterdInfoVo> optional = list1.stream()
                .filter(y -> y.getHisOrderNo().equals("1111"))
                .findFirst();
        if (optional.isPresent()) {
            PatientRegisterdInfoVo registerdInfoVo = optional.get();
            System.out.println("registerdInfoVo = " + registerdInfoVo);
            System.out.println("sizebefore = " + list1.size());
            list1.remove(registerdInfoVo);
            System.out.println("size = " + list1.size());
            list1.forEach(e-> System.out.println(e));
        }

    }


    @Test
    public void  test1(){
        System.out.println("hello world");
    }


}
