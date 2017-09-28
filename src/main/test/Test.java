import com.cn.ssmr.model.PersonProto;
import com.google.protobuf.InvalidProtocolBufferException;
import com.googlecode.protobuf.format.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by sewef on 2017/9/25.
 */
public class Test {

    @Resource
    static ApplicationContext ctx;
    static RedisTemplate redisTemplate;
    static {
        ctx = new ClassPathXmlApplicationContext("spring-context.xml");
        redisTemplate = ctx.getBean("redisTemplate",RedisTemplate.class);
        RedisSerializer stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(stringSerializer);

    }

    @org.junit.Test
    public void testSpringRedis() throws InvalidProtocolBufferException, JsonFormat.ParseException {
        //stringRedisTemplate的操作
        // String读写
//        redisTemplate.delete("myStr");
//        redisTemplate.opsForValue().set("myStr", "houyuxin");
//        System.out.println(redisTemplate.opsForValue().get("myStr"));
//        System.out.println("--------运行结束-------");

        // List读写
//        redisTemplate.delete("myList");
//        redisTemplate.opsForList().rightPush("myList", "T");
//        redisTemplate.opsForList().rightPush("myList", "L");
//        redisTemplate.opsForList().leftPush("myList", "A");
//        List<String> listCache = redisTemplate.opsForList().range(
//                "myList", 0, -1);
//        for (String s : listCache) {
//            System.out.println(s);
//        }
//        System.out.println("---------------");
//
//        // Set读写
//        redisTemplate.delete("myset");
//        redisTemplate.opsForSet().add("myset", "A");
//        redisTemplate.opsForSet().add("myset", "b");
//        redisTemplate.opsForSet().add("myset", "C");
//        Set<String> setCache = redisTemplate.opsForSet().members(
//                "myset");
//        for (String s : setCache) {
//            System.out.println(s);
//        }
//        System.out.println("------运行结束---------");
//
//        // Hash读写
//        redisTemplate.delete("myHash");
//        redisTemplate.opsForHash().put("myHash", "BJ", "北京");
//        redisTemplate.opsForHash().put("myHash", "SH", "上海");
//        redisTemplate.opsForHash().put("myHash", "HN", "河南");
//        Map<String, String> hashCache = redisTemplate.opsForHash()
//                .entries("myHash");
//        for (Map.Entry entry : hashCache.entrySet()) {
//            System.out.println(entry.getKey() + " - " + entry.getValue());
//        }
//        System.out.println("---------------");
        int i = 10;
        PersonProto.Person person = PersonProto.Person.newBuilder()
                .setId(i)
                .setEmail("email"+i)
                .setName("name"+i)
                .addPhone(PersonProto.Person.Phone.newBuilder().setPhoneNum("phoneNum"+i)
                        .setPhoneType(0).build())
                .build();
        redisTemplate.opsForValue().set("myStr", person.toString());
        Object obj = redisTemplate.opsForValue().get("myStr");
        System.out.println(obj.toString().toCharArray());

        PersonProto.Person.Builder person1 = PersonProto.Person.newBuilder();

        String jsonFormat = "{id:11,name:'name10',email:'email10'}";
        JsonFormat.merge(jsonFormat, person1);
        JsonFormat.merge(obj.toString(), person1);
        System.out.println(person1.getEmail());
    }
}
