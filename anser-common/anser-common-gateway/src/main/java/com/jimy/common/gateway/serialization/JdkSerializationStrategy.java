package com.jimy.common.gateway.serialization;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;

/**
 * Serializes objects using {@link JdkSerializationRedisSerializer}
 *
 * @author efenderbosch
 *
 */
@Configuration
public class JdkSerializationStrategy extends StandardStringSerializationStrategy {

	private static final JdkSerializationRedisSerializer OBJECT_SERIALIZER = new JdkSerializationRedisSerializer();

	@Override
	@SuppressWarnings("unchecked")
	protected <T> T deserializeInternal(byte[] bytes, Class<T> clazz) {
		return (T) OBJECT_SERIALIZER.deserialize(bytes);
	}

	@Override
	protected byte[] serializeInternal(Object object) {
		return OBJECT_SERIALIZER.serialize(object);
	}

}
