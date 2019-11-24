package entity;

import java.util.Objects;

public class ExperimentalPlane extends Plane {

    private ExperimentalPlaneType type;
    private ClassificationPlaneLevel classificationPlaneLevel;

    public ExperimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, ExperimentalPlaneType type, ClassificationPlaneLevel classificationPlaneLevel) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.type = type;
        this.classificationPlaneLevel = classificationPlaneLevel;
    }

    public ClassificationPlaneLevel getClassificationPlaneLevel(){
        return classificationPlaneLevel;
    }

    public void setClassificationPlaneLevel(ClassificationPlaneLevel classificationPlaneLevel){
        this.classificationPlaneLevel = classificationPlaneLevel;
    }

    @Override
    public String toString() {
        return "ExperimentalPlane{" +
                "type=" + type +
                ", classificationPlaneLevel=" + classificationPlaneLevel +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ExperimentalPlane that = (ExperimentalPlane) o;
        return type == that.type &&
                classificationPlaneLevel == that.classificationPlaneLevel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), type, classificationPlaneLevel);
    }
}
