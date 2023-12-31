package kr.or.ddit.common.vo;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlarmVO {
	private String type;
	private String sender;
	private String channelId;
	private String receiver;
	private Object data;
	
}
