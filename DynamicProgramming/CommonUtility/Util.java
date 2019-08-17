import java.time.Duration;
import java.time.Instant;

class Util{

static Instant timeTerminal(){
  return Instant.now();
}

static long timeDuration(Instant start, Instant end){
return Duration.between(start, end).toMillis();
}


}
