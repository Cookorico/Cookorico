package fil.iagl.cookorico.controller.util;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final class Constant {

  private Constant() {}
  
  public static final List<String> PICTURE_EXTENSION_VALIDE = Collections.unmodifiableList(Arrays.asList(".jpg", ".jpeg", ".bmp", ".svg", ".gif", ".png"));
  
  public static final String STATIC_RESSOURCE_LOCATION = Arrays.asList("src", "main", "resources", "static").stream().collect(Collectors.joining(Character.toString(File.separatorChar)));
  
  public static final String UPLOADED_PICTURE_LOCATION = Arrays.asList("img", "uploaded").stream().collect(Collectors.joining(Character.toString(File.separatorChar)));
}