package com.bit.dotori.mapper;


import com.bit.dotori.dto.UserDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CashMapper {
    @Select("SELECT user_dotori" +
            "   WHERE user_id = #{userid}")
            void getCashList(int cnt);
    @Insert("INSERT user")

             void chargeCash(UserDTO userDTO);

}
