package fil.iagl.cookorico.controller.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataReturn<T> {

  private T data;
  private String succes;
  private String error;

  public DataReturn() {
    super();
  }

  public DataReturn(T data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return "DataReturn [data=" + data + ", succes=" + succes + ", error=" + error + "]";
  }

}
