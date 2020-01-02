package mate.academy.internetshop.service;

import mate.academy.internetshop.model.Bucket;
import mate.academy.internetshop.model.Item;

import java.util.List;
import java.util.Optional;

public interface BucketService {
    Bucket create(Bucket bucket);

    Optional<Bucket> get(Long bucketId);

    Bucket update(Bucket bucket);

    boolean delete(Long bucketId);

    boolean delete(Bucket bucket);

    void addItem(Bucket bucket, Item item);

    boolean deleteItem(Bucket bucket, Item item);

    void clear(Bucket bucket);

    Optional<List<Item>> getAllItems(Bucket bucket);
}
