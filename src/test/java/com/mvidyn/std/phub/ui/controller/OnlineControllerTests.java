package com.mvidyn.std.phub.ui.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mvidyn.std.phub.ui.model.form.online.data.OnlineCbftData;
import com.mvidyn.std.phub.ui.model.form.online.form.OnlineCbftForm;
import com.mvidyn.std.phub.ui.service.MockData;
import com.mvidyn.std.phub.ui.service.OnlineService;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(OnlineController.class)
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc(addFilters = false)
public class OnlineControllerTests {

	private static final String BASE = "/online";

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private OnlineService onlineService;

	@Autowired
	private ObjectMapper objectMapper;

	private OnlineCbftForm form;

	private OnlineCbftData data;

	@BeforeEach
	public void setup() {
		form = MockData.ONLINE_CBFT_FORM;
		data = MockData.ONLINE_CBFT_DATA;
	}

	@Test
	public void shouldCreateAttributes() {
		assertNotNull(mockMvc);
		assertNotNull(onlineService);
		assertNotNull(objectMapper);
		assertNotNull(form);
		assertNotNull(data);
	}

	@Test
	public void createCbftTransaction_ReturnCreated() throws Exception {
		// Arrange
		String endpoint = BASE + "/cbft/create";
		when(onlineService.createCbftTransaction(ArgumentMatchers.any())).thenReturn(data);

		// Act
		ResultActions response = mockMvc.perform(MockMvcRequestBuilders.post(endpoint)
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(form)));

		// Assert
		response.andExpect(MockMvcResultMatchers.status().isCreated())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id", CoreMatchers.is((int) data.getId())));
	}

}
