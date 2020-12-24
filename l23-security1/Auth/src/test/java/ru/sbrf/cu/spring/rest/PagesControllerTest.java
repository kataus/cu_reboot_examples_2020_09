//package ru.sbrf.cu.spring.rest;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(PagesController.class)
//public class PagesControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @WithMockUser(
//            username = "admin",
//            authorities = {"ROLE_ADMIN"}
//    )
//    @Test
//    public void testAuthenticatedOnAdmin() throws Exception {
//        mockMvc.perform(get("/authenticated"))
//                .andExpect(status().isOk());
//    }
//}
