package MI.com.example.MI_Project.config;

import MI.com.example.MI_Project.security.entities.AppUser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class AppUserSerializer extends StdSerializer<AppUser> {
    public AppUserSerializer() { super(AppUser.class); }

    @Override
    public void serialize(AppUser value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeNumberField("idUser", value.getIdUser());
        //gen.writeStringField("firstname", value.getFirstname());
        gen.writeEndObject();
    }
}
