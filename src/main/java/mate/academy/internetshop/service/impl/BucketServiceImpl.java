package mate.academy.internetshop.service.impl;

import java.util.List;
import java.util.Optional;

import mate.academy.internetshop.dao.BucketDao;
import mate.academy.internetshop.dao.ItemDao;
import mate.academy.internetshop.lib.Inject;
import mate.academy.internetshop.lib.Service;
import mate.academy.internetshop.model.Bucket;
import mate.academy.internetshop.model.Item;
import mate.academy.internetshop.service.BucketService;

@Service
public class BucketServiceImpl implements BucketService {

    @Inject
    private static BucketDao bucketDao;

    @Inject
    private static ItemDao itemDao;

    @Override
    public Bucket create(Bucket bucket) {
        return bucketDao.create(bucket);
    }

    @Override
    public Optional<Bucket> get(Long bucketId) {
        Optional<Bucket> bucket = bucketDao.get(bucketId);
        return bucket;
    }

    @Override
    public Bucket update(Bucket bucket) {
        return bucketDao.update(bucket);
    }

    @Override
    public List<Bucket> getAll() {
        return bucketDao.getAll();
    }

    @Override
    public boolean deleteById(Long bucketId) {
        return bucketDao.deleteById(bucketId);
    }

    @Override
    public boolean delete(Bucket bucket) {
        return bucketDao.delete(bucket);
    }

    @Override
    public void addItem(Bucket bucket, Item item) {
        bucket.getItems().add(item);
        bucketDao.update(bucket);
    }

    @Override
    public void deleteItem(Bucket bucket, Item item) {
        Bucket newBucket = bucketDao.get(bucket.getBucketId()).get();
        List<Item> itemOfBucket = newBucket.getItems();
        itemOfBucket.remove(item);
        bucketDao.update(newBucket);
    }

    @Override
    public void clear(Bucket bucket) {
        Bucket tempBucket = bucketDao.get(bucket.getBucketId()).get();
        tempBucket.getItems().clear();
        bucketDao.update(tempBucket);
    }

    @Override
    public Bucket getByUserId(Long userId) {
        List<Bucket> list = bucketDao.getAll();
        Optional<Bucket> bucket = bucketDao.getAll().stream()
                .filter(x -> x.getUserId().equals(userId))
                .findFirst();
        if (bucket.isPresent()) {
            return bucket.get();
        }
        return create(new Bucket(userId));
    }

    @Override
    public List<Item> getAllItems(Bucket bucket) {
        return bucketDao.get(bucket.getBucketId()).get().getItems();
    }
}
