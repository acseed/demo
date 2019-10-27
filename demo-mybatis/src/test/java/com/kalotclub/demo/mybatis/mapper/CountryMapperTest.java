package com.kalotclub.demo.mybatis.mapper;

import com.kalotclub.demo.mybatis.model.Country;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * Date: 2019-08-31 10:13
 *
 * @author hongchen.cao
 */
@Slf4j
public class CountryMapperTest {
    private static SqlSessionFactory sqlSessionFactory;

    @BeforeClass
    public static void init() throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        reader.close();
    }

    @Test
    public void testSelectAll() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            List<Country> countries = session.selectList("selectAll");
            log.info("countries size={}", countries.size());
            Assert.assertEquals(countries.size(), 5);
        } finally {
            session.close();
        }
    }


}